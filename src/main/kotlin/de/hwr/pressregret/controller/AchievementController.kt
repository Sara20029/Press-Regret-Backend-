package de.hwr.pressregret.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/achievements")
class AchievementController {

    @GetMapping
    fun getAchievements() = "achievements"
}