package de.hwr.pressregret.controller

import de.hwr.pressregret.api.request.RunStartRequest
import de.hwr.pressregret.api.response.RunResponse
import de.hwr.pressregret.service.RunService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/runs")
class RunController(private val runService: RunService) {


    @PostMapping
    fun start(@RequestBody request: RunStartRequest): RunResponse {

        val run = runService.start(request)

        return RunResponse(
            runId = run.runId,
            levelId = run.levelId,
            status = run.status
        )
    }

    @PostMapping("/{runId}/press")
    fun press(@PathVariable runId: Int): RunResponse {

        val currentRun = runService.press(runId)

        return RunResponse(
            runId = currentRun.runId,
            levelId = currentRun.levelId,
            status = currentRun.status
        )
    }

    @PostMapping("/{runId}/finish")
    fun finish(@PathVariable runId: Int): RunResponse {

        val currentRun = runService.finish(runId)

        return RunResponse(
            runId = currentRun.runId,
            levelId = currentRun.levelId,
            status = currentRun.status
        )
    }

    @PostMapping("/{runId}/release")
    fun release(@PathVariable runId: Int): RunResponse {

        val currentRun = runService.release(runId)

        return RunResponse(
            runId = currentRun.runId,
            levelId = currentRun.levelId,
            status = currentRun.status
        )
    }

}