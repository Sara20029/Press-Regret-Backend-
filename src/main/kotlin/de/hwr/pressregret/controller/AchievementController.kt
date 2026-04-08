package de.hwr.pressregret.controller

import de.hwr.pressregret.api.response.AchievementResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import de.hwr.pressregret.service.AchievementService


@RestController
@RequestMapping("/api/achievements")
class AchievementController (private val achievementService: AchievementService) {

    @GetMapping
    fun Achievements() : List<AchievementResponse> {
        return achievementService.getAchievements()
    }


    @PostMapping("/{achievementId}/unlock")
    fun unlockAchievement(@PathVariable achievementId: Int) : String {

        achievementService.unlock(achievementId)
        return "Achievement $achievementId unlocked"
    }
}