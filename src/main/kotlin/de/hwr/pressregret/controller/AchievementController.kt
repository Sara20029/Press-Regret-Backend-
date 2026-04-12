package de.hwr.pressregret.controller

import de.hwr.pressregret.api.request.AchievementUpdateRequest
import de.hwr.pressregret.api.response.AchievementResponse
import org.springframework.web.bind.annotation.*
import de.hwr.pressregret.service.AchievementService
import org.springframework.http.HttpStatus


/**
 * Controller for managing player achievements.
 * Delegates all logic to AchievementServices
 */
@RestController
@RequestMapping("/api/achievements")
class AchievementController (private val achievementService: AchievementService) {

    // Returns all achievements with their current unlock status
    @GetMapping
    fun achievements() : List<AchievementResponse> {
        return achievementService.getAchievements()
    }


    //Updates the unlock state of a specific achievement
    @PutMapping("/{achievementId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateAchievement(
            @PathVariable achievementId: Int,
            @RequestBody request: AchievementUpdateRequest
    ) : AchievementResponse {
        return achievementService.update(achievementId, request.unlocked)
    }
}