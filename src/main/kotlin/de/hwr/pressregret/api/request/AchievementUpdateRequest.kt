package de.hwr.pressregret.api.request

// Request body for updating the unlock state of an achievement
data class AchievementUpdateRequest (
    val unlocked: Boolean
)