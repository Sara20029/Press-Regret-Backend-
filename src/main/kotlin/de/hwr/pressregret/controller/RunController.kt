package de.hwr.pressregret.controller

import de.hwr.pressregret.api.request.RunStartRequest
import de.hwr.pressregret.api.response.RunResponse
import de.hwr.pressregret.model.Run
import de.hwr.pressregret.service.LevelService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/runs")
class RunController(private val levelService: LevelService) {

    private val runs = mutableMapOf<Int, Run>()
    private var nextRunId = 1

    @PostMapping
    fun startRun(@RequestBody request: RunStartRequest): RunResponse {
        val runId = nextRunId
        nextRunId++

        runs[runId] = Run(
            runId = runId,
            levelId = request.levelId,
            startedAt = System.currentTimeMillis(),
            status = "RUNNING"
        )

        return RunResponse(
            runId = runId,
            levelId = request.levelId,
            status = "RUNNING"
        )
    }

    @PostMapping("/{runId}/press")
    fun press(@PathVariable runId: Int): RunResponse {


        val currentRun = runs[runId] ?: throw IllegalArgumentException("Run not found")
        currentRun.pressCount++
        val level = levelService.getLevelById(currentRun.levelId)
            ?: throw IllegalArgumentException("Level not found")

        if (currentRun.status == "RUNNING"){
            currentRun.status = when (level.type) {
                "PRESS_X_TIMES" -> if (currentRun.pressCount == level.requiredPresses) "SUCCESS" else "RUNNING"
                "DO_NOT_PRESS" -> "FAILED"
                "HOLD" -> "RUNNING"
                "NOT_X_TIMES" -> if (currentRun.pressCount != level.requiredPresses) "SUCCESS" else "FAILED"
                else -> "FAILED"
            }
        }


        return RunResponse(
            runId = runId,
            levelId = currentRun.levelId,
            status = currentRun.status
        )
    }

    @PostMapping("/{runId}/finish")
    fun finish(@PathVariable runId: Int): RunResponse {

        val currentRun = runs[runId] ?: throw IllegalArgumentException("Run not found")
        val level = levelService.getLevelById(currentRun.levelId)
            ?: throw IllegalArgumentException("Level not found")

        if (currentRun.status == "RUNNING") {
            currentRun.status = when (level.type) {
                "DO_NOT_PRESS" -> if (currentRun.pressCount == 0) "SUCCESS" else "FAILED"
                "NOT_X_TIMES" -> if (currentRun.pressCount != level.requiredPresses) "SUCCESS" else "FAILED"
                "HOLD" -> "SUCCESS"
                else -> "FAILED"
            }
        }
        return RunResponse(
            runId = runId,
            levelId = currentRun.levelId,
            status = currentRun.status
        )
    }

    @PostMapping("/{runId}/release")
    fun release(@PathVariable runId: Int): RunResponse {
        val currentRun = runs[runId] ?: throw IllegalArgumentException("Run not found")
        val level = levelService.getLevelById(currentRun.levelId)
            ?: throw IllegalArgumentException("Level not found")

        if (currentRun.status == "RUNNING" && level.type == "HOLD") {
            currentRun.status = "FAILED"
        }
        return RunResponse(
            runId = runId,
            levelId = currentRun.levelId,
            status = currentRun.status
        )
    }

}