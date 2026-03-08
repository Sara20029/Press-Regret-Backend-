package de.hwr.pressregret.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/settings")
class SettingsController {

    @GetMapping("/sound")
    fun getSoundSettings() = println("Sound settings:")

    @GetMapping("/music")
    fun getMusicSettings() = println("Music settings:")

    @GetMapping("/notifications")
    fun getNotificationsSettings() = println("Notifications settings:")

    @GetMapping("/language")
    fun getLanguageSettings() = println("Language settings:")

    @GetMapping("/theme")
    fun getThemeSettings() = println("Theme settings:")

    @PutMapping()
    fun updateSettings() = println("Settings updated!")

}