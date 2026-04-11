package de.hwr.pressregret.controller

import de.hwr.pressregret.api.response.AchievementResponse
import org.springframework.web.bind.annotation.*
import de.hwr.pressregret.service.AchievementService
import org.springframework.http.HttpStatus



@RestController
@RequestMapping("/api/achievements")
class AchievementController (private val achievementService: AchievementService) {

    @GetMapping
    fun achievements() : List<AchievementResponse> {
        return achievementService.getAchievements()
    }


    @PostMapping("/{achievementId}/unlock")
    @ResponseStatus(HttpStatus.CREATED)
    fun unlockAchievement(@PathVariable achievementId: Int) : AchievementResponse {
        return achievementService.unlock(achievementId)
    }
}