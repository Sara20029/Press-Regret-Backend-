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
        return runService.start(request)
    }

    @PostMapping("/{runId}/press")
    fun press(@PathVariable runId: Int): RunResponse {
        return runService.press(runId)
    }

    @PostMapping("/{runId}/finish")
    fun finish(@PathVariable runId: Int): RunResponse {
        return runService.finish(runId)
    }

    @PostMapping("/{runId}/release")
    fun release(@PathVariable runId: Int): RunResponse {
        return runService.release(runId)
    }

}