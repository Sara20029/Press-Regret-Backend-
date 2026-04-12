package de.hwr.pressregret.controller

import de.hwr.pressregret.api.dto.SettingsDto
import de.hwr.pressregret.service.SettingsService
import org.springframework.web.bind.annotation.*

/**
 * Controller for managing user settings.
 * Delegates all logic to SettingsService.
 */
@RestController
@RequestMapping("/api/settings")
class SettingsController(private val settingsService: SettingsService) {

    // Returns the current user settings
    @GetMapping()
    fun getSettings(): SettingsDto {
        return settingsService.getSettings()
    }

    // Updates the user settings and returns the updated state
    @PutMapping()
    fun updateSettings(@RequestBody settings: SettingsDto): SettingsDto {
        return settingsService.updateSettings(settings)
    }
}