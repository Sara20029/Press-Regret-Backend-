package de.hwr.pressregret.service

import de.hwr.pressregret.api.dto.SettingsDto
import org.springframework.stereotype.Service

/**
 * Service managing user Settings (theme, language, sound).
 * Settings are stored in-memory and reset in server restart.
 */
@Service
class SettingsService {

    // Default settings applied on startup
    private var currentSettings = SettingsDto(
        theme = "dark",
        language = "en",
        soundEnabled = true
    )

    // Returns the current settings.
    fun getSettings(): SettingsDto {
        return currentSettings
    }

    /**
     * Updates and persists the given settings.
     * Returns the updated settings.
     */
    fun updateSettings(settings: SettingsDto): SettingsDto {
        currentSettings.theme = settings.theme
        currentSettings.language = settings.language
        currentSettings.soundEnabled = settings.soundEnabled
        return currentSettings
    }
}