package de.hwr.pressregret.controller

import de.hwr.pressregret.api.dto.SettingsDto
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/settings")
class SettingsController {
    private var currentSettings = SettingsDto(
        theme = "dark", language = "en", soundEnabled = true
    )


    @GetMapping()
    fun getSoundSettings(): SettingsDto {
        return currentSettings
    }

    @PutMapping()
    fun updateSettings(@RequestBody settings: SettingsDto): SettingsDto {
        currentSettings.theme = settings.theme
        currentSettings.language = settings.language
        currentSettings.soundEnabled = settings.soundEnabled
        return currentSettings
    }
}