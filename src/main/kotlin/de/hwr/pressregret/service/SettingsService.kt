package de.hwr.pressregret.service

import de.hwr.pressregret.api.dto.SettingsDto
import org.springframework.stereotype.Service

@Service
class SettingsService {

    private var currentSettings = SettingsDto(
        theme = "dark",
        language = "en",
        soundEnabled = true
    )

    fun getSettings(): SettingsDto {
        return currentSettings
    }

    fun updateSettings(settings: SettingsDto): SettingsDto {
        currentSettings.theme = settings.theme
        currentSettings.language = settings.language
        currentSettings.soundEnabled = settings.soundEnabled
        return currentSettings
    }
}