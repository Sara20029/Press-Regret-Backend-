package de.hwr.pressregret.controller

import de.hwr.pressregret.api.response.DifficultyResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/difficulties")
class DifficultyController {

    @GetMapping
    fun difficulties(): List<DifficultyResponse> {
        return listOf(
            DifficultyResponse(
                id = 1,
                name = "Easy",
                description = "Good for beginners!"
            ),
            DifficultyResponse(
                id = 2,
                name = "Medium",
                description = "Balanced challenge"
            ),
            DifficultyResponse(
                id = 3,
                name = "Hard",
                description = "Only for experts"
            ))
    }

    @GetMapping("/{difficultyId}")
    fun difficulty(@PathVariable difficultyId: Int): DifficultyResponse {
        return when (difficultyId) {
            1 -> DifficultyResponse(
                id = 1,
                name = "Easy",
                description = "Good for beginners!"
            )
            2 -> DifficultyResponse(
                id = 2,
                name = "Medium",
                description = "Balanced challenge"
            )
            3 -> DifficultyResponse(
                id = 3,
                name = "Hard",
                description = "Only for experts"
            )
            else -> throw IllegalArgumentException("Invalid difficultyId: $difficultyId")
        }
    }

}