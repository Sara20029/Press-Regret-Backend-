package de.hwr.pressregret.api.response

data class LevelResponse(
    val levelId: Int,
    val difficulty: Int,
    val number: Int,
    val instruction: String,
    val type: String,
    val requiredPresses: Int? = null
)