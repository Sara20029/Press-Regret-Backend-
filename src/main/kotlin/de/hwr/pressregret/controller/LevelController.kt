package de.hwr.pressregret.controller


import de.hwr.pressregret.api.response.LevelResponse
import de.hwr.pressregret.service.LevelService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class LevelController(private val levelService: LevelService) {

    @GetMapping("/difficulties/{difficultyId}/levels")
    fun levels(@PathVariable difficultyId: Int): List<LevelResponse> {
        return levelService.getLevelsByDifficulty(difficultyId)
    }
}
