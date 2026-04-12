package de.hwr.pressregret.api.request

// Request body for submitting player feedback
data class FeedbackRequest (
    val name: String,
    val rating: Int,
    val message: String
)