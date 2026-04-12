package de.hwr.pressregret.api.response

// Represents a single game level with its type and optional configuration
data class LevelResponse(
    val levelId: Int,
    val difficulty: Int,
    val number: Int,
    val instruction: String,
    val type: String,
    val requiredPresses: Int? = null,
    val imageUrl: String? = null
)