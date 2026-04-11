package de.hwr.pressregret.service

import de.hwr.pressregret.api.request.RunStartRequest
import de.hwr.pressregret.api.response.RunResponse
import de.hwr.pressregret.model.Run
import org.springframework.stereotype.Service

@Service
class RunService(private val levelService: LevelService, private val achievementService: AchievementService) {

    private val runs = mutableMapOf<Int, Run>()
    private var nextRunId = 1

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

    fun press(runId: Int): RunResponse {

        val currentRun = runs[runId] ?: throw IllegalArgumentException("Run not found")
        currentRun.pressCount++
        val level = levelService.getLevelById(currentRun.levelId)
            ?: throw IllegalArgumentException("Level not found")

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

    fun finish(runId: Int): RunResponse {

        val currentRun = runs[runId] ?: throw IllegalArgumentException("Run not found")
        val level = levelService.getLevelById(currentRun.levelId)
            ?: throw IllegalArgumentException("Level not found")


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

    fun release(runId: Int): RunResponse {
        val currentRun = runs[runId] ?: throw IllegalArgumentException("Run not found")
        val level = levelService.getLevelById(currentRun.levelId)
            ?: throw IllegalArgumentException("Level not found")

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