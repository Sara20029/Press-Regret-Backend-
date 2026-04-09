package de.hwr.pressregret.service

import de.hwr.pressregret.api.request.RunStartRequest
import de.hwr.pressregret.model.Run
import org.springframework.stereotype.Service

@Service
class RunService(private val levelService: LevelService, private val achievementService: AchievementService) {

    private val runs = mutableMapOf<Int, Run>()
    private var nextRunId = 1

    fun start(request: RunStartRequest): Run {
        val runId = nextRunId
        nextRunId++

        val run = Run(
            runId = runId, levelId = request.levelId, startedAt = System.currentTimeMillis(), status = "RUNNING"
        )
        runs[runId] = run
        return run

    }

    fun press(runId: Int): Run {

        val currentRun = runs[runId] ?: throw IllegalArgumentException("Run not found")
        currentRun.pressCount++
        val level = levelService.getLevelById(currentRun.levelId) ?: throw IllegalArgumentException("Level not found")

        if (currentRun.status == "RUNNING") {
            currentRun.status = when (level.type) {
                "PRESS" -> "SUCCESS"
                "PRESS_X_TIMES" -> if (currentRun.pressCount == level.requiredPresses) "SUCCESS" else "RUNNING"
                "DO_NOT_PRESS" -> "FAILED"
                "HOLD" -> "RUNNING"
                "NOT_X_TIMES" -> if (currentRun.pressCount != level.requiredPresses) "SUCCESS" else "FAILED"
                else -> "FAILED"
            }
        }

        if (currentRun.status == "SUCCESS") {
            achievementService.checkAndUnlock(level.levelId)
        }

        return currentRun
    }

    fun finish(runId: Int): Run {

        val currentRun = runs[runId] ?: throw IllegalArgumentException("Run not found")
        val level = levelService.getLevelById(currentRun.levelId) ?: throw IllegalArgumentException("Level not found")

        if (currentRun.status == "RUNNING") {
            currentRun.status = when (level.type) {
                "DO_NOT_PRESS" -> if (currentRun.pressCount == 0) "SUCCESS" else "FAILED"
                "NOT_X_TIMES" -> if (currentRun.pressCount != level.requiredPresses) "SUCCESS" else "FAILED"
                "HOLD" -> if (currentRun.pressCount == 0) "FAILED" else "SUCCESS"
                "READ_ONLY" -> "SUCCESS"
                else -> "FAILED"
            }
        }

        if (currentRun.status == "SUCCESS") {
            achievementService.checkAndUnlock(level.levelId)
        }

        return currentRun
    }

    fun release(runId: Int): Run {
        val currentRun = runs[runId] ?: throw IllegalArgumentException("Run not found")
        val level = levelService.getLevelById(currentRun.levelId) ?: throw IllegalArgumentException("Level not found")

        if (currentRun.status == "RUNNING" && level.type == "HOLD") {
            currentRun.status = "FAILED"
        }

        return currentRun
    }

}