package de.hwr.pressregret.api.response

// Response respresenting a single achievement with its unlock status
data class AchievementResponse (
    val text: String = "",
    val id: Int,
    val key: String,
    val title: String,
    val description: String,
    val unlocked: Boolean
)

