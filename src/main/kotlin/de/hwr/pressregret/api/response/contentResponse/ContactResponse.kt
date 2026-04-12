package de.hwr.pressregret.api.response.contentResponse

// Response containing the contact page content
data class ContactResponse(
    val title: String,
    val description: String,
    val email: String
)