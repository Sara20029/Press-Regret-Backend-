package de.hwr.pressregret.service

import de.hwr.pressregret.api.request.RunStartRequest
import de.hwr.pressregret.api.response.RunResponse
import de.hwr.pressregret.model.Run
import org.springframework.stereotype.Service


/**
 * Service managing the game run lifecycle.
 *
 * A "run" represents a single level attempt by the player.
 * Runs are stored in-memory and identified by a unique run ID.
 * The service evaluates win/loss conditions on each player interaction based on the level type (e.g. PRESS, HOLD, etc...)
 */
@Service
class RunService(private val levelService: LevelService, private val achievementService: AchievementService) {

    // In-memory store of active runs, keyed by run ID
    private val runs = mutableMapOf<Int, Run>()

    // Auto-incrementing ID for new runs
    private var nextRunId = 1

    /**
     * Starts a new run for a given level.
     * Initializes the run with status RUNNING and records the start time.
     */
    fun start(request: RunStartRequest): RunResponse {
        val runId = nextRunId
        nextRunId++

        val run = Run(
            runId = runId,
            levelId = request.levelId,
            startedAt = System.currentTimeMillis(),
            status = "RUNNING"
        )
        runs[runId] = run

        return RunResponse(
            runId = run.runId,
            levelId = run.levelId,
            status = run.status
        )
    }

    /**
     * Registers a button press for the given run and evaluates the result.
     * - PRESS: succeeds when the press count matches requiredPresses (1)
     * - PRESS_X_TIMES: stays RUNNING until press count reaches requiredPresses
     * - DO_NOT_PRESS: immediately fails on any press
     * - HOLD: stays RUNNING (win is evaluated on release/finish)
     * - NOT_X_TIMES: succeeds as long as press count differs from requiredPresses
     *
     * If the run reaches SUCESS, achievements are checked and potentially unlocked.
     */
    fun press(runId: Int): RunResponse {

        val currentRun = runs[runId] ?: throw NoSuchElementException("Run $runId not found")
        currentRun.pressCount++
        val level = levelService.getLevelById(currentRun.levelId)
            ?: throw NoSuchElementException("Level not found")

        if (currentRun.status == "RUNNING") {
            currentRun.status = when (level.type) {
                "PRESS" -> if (currentRun.pressCount == level.requiredPresses) "SUCCESS" else "FAILED"
                "PRESS_X_TIMES" -> if (currentRun.pressCount == level.requiredPresses) "SUCCESS" else "RUNNING"
                "DO_NOT_PRESS" -> "FAILED"
                "HOLD" -> "RUNNING"
                "NOT_X_TIMES" -> if (currentRun.pressCount != level.requiredPresses) "SUCCESS" else "FAILED"
                else -> "FAILED"
            }
        }

        val achievementKey = if (currentRun.status == "SUCCESS") {
            achievementService.checkAndUnlock(level.levelId)
        } else null

        return RunResponse(
            runId = currentRun.runId,
            levelId = currentRun.levelId,
            status = currentRun.status,
            unlockedAchievementKey = achievementKey
        )
    }

    /**
     * Finishes a run when the timer expires.
     *
     * Evaluates the final result based on the level type:
     * - PRESS: succeeds only if press count matches requiredPresses (1)
     * - DO_NOT_PRESS: succeeds if press count matches requiredPresses (0)
     * - NOT_X_TIMES: succeeds if press count differs from requiredPresses
     * - HOLD: fails if the button was never pressed, succeeds otherwise
     * - READ_ONLY: always succeeds (observation-only level)
     *
     */
    fun finish(runId: Int): RunResponse {

        val currentRun = runs[runId] ?: throw NoSuchElementException("Run $runId not found")
        val level = levelService.getLevelById(currentRun.levelId)
            ?: throw NoSuchElementException("Level not found")


        if (currentRun.status == "RUNNING") {
            currentRun.status = when (level.type) {
                "PRESS" -> if (currentRun.pressCount != level.requiredPresses) "FAILED" else "SUCCESS"
                "DO_NOT_PRESS" -> if (currentRun.pressCount == level.requiredPresses) "SUCCESS" else "FAILED"
                "NOT_X_TIMES" -> if (currentRun.pressCount != level.requiredPresses) "SUCCESS" else "FAILED"
                "HOLD" -> if (currentRun.pressCount == 0) "FAILED" else "SUCCESS"
                "READ_ONLY" -> "SUCCESS"
                else -> "FAILED"
            }
        }

        val achievementKey = if (currentRun.status == "SUCCESS") {
            achievementService.checkAndUnlock(level.levelId)
        } else null

        return RunResponse(
            runId = currentRun.runId,
            levelId = currentRun.levelId,
            status = currentRun.status,
            unlockedAchievementKey = achievementKey
        )
    }

    /**
     * Registers a button release event, used exclusively for HOLD-type levels.
     *
     * For HOLD levels: releasing the button before the timer expires results in FAILED.
     * For all other level types, release has no effect on the run status.
     */
    fun release(runId: Int): RunResponse {
        val currentRun = runs[runId] ?: throw NoSuchElementException("Run $runId not found")
        val level = levelService.getLevelById(currentRun.levelId)
            ?: throw NoSuchElementException("Level not found")

        if (currentRun.status == "RUNNING" && level.type == "HOLD") {
            currentRun.status = "FAILED"
        }

        return RunResponse(
            runId = currentRun.runId,
            levelId = currentRun.levelId,
            status = currentRun.status
        )
    }

}