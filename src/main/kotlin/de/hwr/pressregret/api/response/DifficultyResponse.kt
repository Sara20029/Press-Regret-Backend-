package de.hwr.pressregret.api.response

// Response representing a game difficulty level
data class DifficultyResponse(
    val id: Int,
    val name: String,
    val description: String
)