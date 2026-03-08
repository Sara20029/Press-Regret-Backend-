package de.hwr.pressregret.controller

import de.hwr.pressregret.api.request.RunStartRequest
import de.hwr.pressregret.api.response.RunResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/runs")
class RunController {
    private var nextrunId = 1

    @PostMapping
    fun startRun(@RequestBody request: RunStartRequest) : RunResponse {

            val runId = nextrunId
            nextrunId++

        return RunResponse(
            runId = runId,
            levelId = request.levelId,
            status = "started"
        )
    }

    @GetMapping("/{runId}")
    fun getRun(@PathVariable runId: Int) : RunResponse {
        return RunResponse(
            runId = runId,
            levelId = 1,
            status = "running"
        )
    }

    @PostMapping("/{runId}/press")
    fun pressButton(@PathVariable runId: Int) = println("Button pressed!")

    @PostMapping("/{runId}/finish")
    fun finishRun(@PathVariable runId: Int) = println("Run finished!")
}