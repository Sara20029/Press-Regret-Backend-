package de.hwr.pressregret.controller

import de.hwr.pressregret.api.request.FeedbackRequest
import de.hwr.pressregret.api.response.FeedbackResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/feedback")
class FeedbackController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun sendFeedback(@RequestBody request: FeedbackRequest): FeedbackResponse{
        println("Feedback received: ${request.name} - ${request.rating} - ${request.message}")
        return FeedbackResponse(
            message = "Thank you for your feedback!"
        )
    }
}