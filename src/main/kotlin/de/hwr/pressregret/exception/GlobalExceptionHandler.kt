package de.hwr.pressregret.exception


import de.hwr.pressregret.api.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * Global exception handler for all REST controllers.
 * Maps exceptions to appropriate HTTP responses
 */
@RestControllerAdvice
class GlobalExceptionHandler {

    // Maps NoSuchElementException to 404 Not Found
    @ExceptionHandler(NoSuchElementException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(ex: NoSuchElementException): ErrorResponse {
            return ErrorResponse(
                status = 404,
                error = "Not Found",
                message = ex.message ?: "Ressource not Found"
        )
    }

    // Maps IllegalArgumentException to 400 Bad Request
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequest(ex: IllegalArgumentException): ErrorResponse {
            return ErrorResponse(
                status = 400,
                error = "Bad Request",
                message = ex.message ?: "Invalid request"
        )
    }
}