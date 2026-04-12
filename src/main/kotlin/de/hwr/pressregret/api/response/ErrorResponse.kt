package de.hwr.pressregret.api.response

// Structured error response returned by the GlobalExceptionHandler
data class ErrorResponse (
    val status: Int, /// HTTP status code
    val error: String, // short error description
    val message: String // detailed error message
)