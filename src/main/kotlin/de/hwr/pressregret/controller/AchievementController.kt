package de.hwr.pressregret.controller

import de.hwr.pressregret.api.request.AchievementUpdateRequest
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


    @PutMapping("/{achievementId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateAchievement(
            @PathVariable achievementId: Int,
            @RequestBody request: AchievementUpdateRequest
    ) : AchievementResponse {
        return achievementService.update(achievementId, request.unlocked)
    }
}