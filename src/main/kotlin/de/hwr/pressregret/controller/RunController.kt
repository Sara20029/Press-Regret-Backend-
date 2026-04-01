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
        val level = levelService.getLevelById(currentRun.levelId)
            ?: throw IllegalArgumentException("Level not found")

        if (currentRun.status == "RUNNING") {
            if (level.type == "PRESS") {
                currentRun.status = "SUCCESS"
            } else {
                currentRun.status = "FAILED"
            }
        }
        return RunResponse(
            runId = runId,
            levelId = currentRun.levelId,
            status = currentRun.status
        )
    }

    /*@PostMapping
    fun startRun(@RequestBody request: RunStartRequest) : Run {

            val runId = nextRunId
            nextRunId++

        return Run(
            runId = runId,
            levelId = request.levelId,
            startedAt = 5,
            status = "started"
        )
    }*/

    /*@GetMapping("/{runId}")
    fun getRun(@PathVariable runId: Int): Run {
        return Run(
            runId = runId,
            levelId = 1,
            startedAt = 5,
            status = "running"
        )
    }*/


    @PostMapping("/{runId}/finish")
    fun finishRun(@PathVariable runId: Int) = println("Run finished!")
}