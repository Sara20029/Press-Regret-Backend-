package de.hwr.pressregret.api.response.contentResponse

data class HowToPlayResponse(
    val title: String,
    val description: String,
    val instructions: List<String>
)