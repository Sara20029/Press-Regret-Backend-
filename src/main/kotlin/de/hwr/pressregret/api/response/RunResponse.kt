package de.hwr.pressregret.api.response

data class RunResponse(
    val runId: Int,
    val levelId: Int,
    val status: String,
)