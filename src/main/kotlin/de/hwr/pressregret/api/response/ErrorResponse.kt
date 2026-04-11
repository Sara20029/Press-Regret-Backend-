package de.hwr.pressregret.api.response

data class ErrorResponse (
    val status: Int,
    val error: String,
    val message: String
)