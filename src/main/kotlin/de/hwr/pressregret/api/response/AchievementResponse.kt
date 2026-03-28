package de.hwr.pressregret.api.response

data class AchievementResponse (
    val text: String = "",
    val id: Int,
    val title: String,
    val description: String,
    val unlocked: Boolean
)

