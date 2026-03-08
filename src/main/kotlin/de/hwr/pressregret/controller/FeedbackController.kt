package de.hwr.pressregret.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/feedback")
class FeedbackController {

    @PostMapping
    fun sendFeedback() = println("Feedback received!")
}