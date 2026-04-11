package de.hwr.pressregret.controller

import de.hwr.pressregret.api.request.FeedbackRequest
import de.hwr.pressregret.api.response.FeedbackResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/feedback")
class FeedbackController {

    private val logger = LoggerFactory.getLogger(FeedbackController::class.java)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun sendFeedback(@RequestBody request: FeedbackRequest): FeedbackResponse{
        logger.info("Feedback received: ${request.name} - ${request.rating} - ${request.message}")
        return FeedbackResponse(
            message = "Thank you for your feedback!"
        )
    }
}