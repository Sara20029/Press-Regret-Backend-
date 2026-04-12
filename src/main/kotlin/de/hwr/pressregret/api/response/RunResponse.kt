package de.hwr.pressregret.api.response

// Response containing the result of a run action
data class RunResponse (
    val runId: Int,
    val levelId: Int,
    val status: String,
    val unlockedAchievementKey: String? = null
)