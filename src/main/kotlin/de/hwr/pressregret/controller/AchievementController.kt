package de.hwr.pressregret.controller

import de.hwr.pressregret.api.response.AchievementResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/achievements")
class AchievementController {

    @GetMapping
    fun getAchievements() = listOf(
        AchievementResponse(
            id = 1,
            title = "First Level",
            description = "Complete the first level!",
            unlocked = false
        ),
        AchievementResponse(
            id = 2,
            title = "Easy Level",
            description = "Complete the easy level!",
            unlocked = false
        ),
        AchievementResponse(
            id = 3,
            title = "Medium Level",
            description = "Complete the medium level!",
            unlocked = false
        )

    )
}