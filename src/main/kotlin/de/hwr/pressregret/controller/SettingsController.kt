package de.hwr.pressregret.controller

import de.hwr.pressregret.api.dto.SettingsDto
import de.hwr.pressregret.service.SettingsService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/settings")
class SettingsController(private val settingsService: SettingsService) {

    @GetMapping()
    fun getSettings(): SettingsDto {
        return settingsService.getSettings()
    }

    @PutMapping()
    fun updateSettings(@RequestBody settings: SettingsDto): SettingsDto {
        return settingsService.updateSettings(settings)
    }
}