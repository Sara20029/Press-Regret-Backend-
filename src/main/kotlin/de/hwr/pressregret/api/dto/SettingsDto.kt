package de.hwr.pressregret.api.dto

// DTO for transferring user settings between frontend and backend
data class SettingsDto (
    var theme: String,
    var language: String,
    var soundEnabled: Boolean
)