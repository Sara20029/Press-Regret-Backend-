package de.hwr.pressregret.model

data class Run(
    val runId: Int,
    val levelId: Int,
    val startedAt: Long,
    var status: String,
    var pressCount: Int = 0,
)