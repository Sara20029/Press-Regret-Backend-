package de.hwr.pressregret.api.dto

data class SettingsDto (
    var theme: String,
    var language: String,
    var soundEnabled: Boolean
)