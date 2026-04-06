package de.hwr.pressregret.api.request

data class FeedbackRequest (
    val name: String,
    val rating: Int,
    val message: String
)