package de.hwr.pressregret.api.response.contentResponse

// Response containing the how to play page content
data class HowToPlayResponse(
    val title: String,
    val description: String,
    val instructions: List<String>
)