package de.hwr.pressregret.controller

import de.hwr.pressregret.api.request.RunStartRequest
import de.hwr.pressregret.api.response.RunResponse
import de.hwr.pressregret.service.RunService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * Controller for managing game runs.
 * A run represents a single level attempt by the player
 */
@RestController
@RequestMapping("/api/runs")
class RunController(private val runService: RunService) {

    /**
     * Starts a new run for the given level.
     * returns the created run with status RUNNING.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun start(@RequestBody request: RunStartRequest): RunResponse {
        return runService.start(request)
    }

    /**
     * Registers a button press for the given run.
     * Evaluates win/loss conditions depending on the level type.
     */
    @PostMapping("/{runId}/press")
    fun press(@PathVariable runId: Int): RunResponse {
        return runService.press(runId)
    }

    /**
     * Finishes a run when the timer expires.
     */
    @PostMapping("/{runId}/finish")
    fun finish(@PathVariable runId: Int): RunResponse {
        return runService.finish(runId)
    }

    /**
     * Registers a button release (used for HOLD-type levels).
     */
    @PostMapping("/{runId}/release")
    fun release(@PathVariable runId: Int): RunResponse {
        return runService.release(runId)
    }

}