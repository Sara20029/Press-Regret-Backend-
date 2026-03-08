package de.hwr.pressregret.controller


import de.hwr.pressregret.api.response.LevelResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class LevelController {

    @GetMapping("/difficulties/{difficultyId}/levels")
    fun levels(@PathVariable difficultyId: Int): List<LevelResponse> {
        return when (difficultyId) {
            1 -> getEasyLevels()
            2 -> getMediumLevels()
            3 -> getHardLevels()
            else -> throw IllegalArgumentException("Invalid difficultyId: $difficultyId")
        }
    }

    private fun getEasyLevels(): List<LevelResponse> {
        return listOf(
            LevelResponse(1, 1, 1, "Press after 1 second"),
            LevelResponse(2, 1, 2, "Press after 2 seconds"),
            LevelResponse(3, 1, 3, "Press after 3 seconds"),
            LevelResponse(4, 1, 4, "Press after 4 seconds"),
            LevelResponse(5, 1, 5, "Press after 5 seconds"),
            LevelResponse(6, 1, 6, "Press after 6 seconds"),
            LevelResponse(7, 1, 7, "Press after 7 seconds"),
            LevelResponse(8, 1, 8, "Press after 8 seconds"),
            LevelResponse(9, 1, 9, "Press after 9 seconds"),
            LevelResponse(10, 1, 10, "Press after 10 seconds")
        )
    }

    private fun getMediumLevels(): List<LevelResponse> {
        return listOf(
            LevelResponse(11, 2, 1, "Press after 1.5 second"),
            LevelResponse(12, 2, 2, "Press after 2.5 seconds"),
            LevelResponse(13, 2, 3, "Press after 3.5 seconds"),
            LevelResponse(14, 2, 4, "Press after 4.5 seconds"),
            LevelResponse(15, 2, 5, "Press after 5.5 seconds"),
            LevelResponse(16, 2, 6, "Press after 6.5 seconds"),
            LevelResponse(17, 2, 7, "Press after 7.5 seconds"),
            LevelResponse(18, 2, 8, "Press after 8.5 seconds"),
            LevelResponse(19, 2, 9, "Press after 9.5 seconds"),
            LevelResponse(20, 2, 10, "Press after 10.5 seconds")
        )
    }

    private fun getHardLevels(): List<LevelResponse> {
        return listOf(
            LevelResponse(21, 3, 1, "Press after 1.2 second"),
            LevelResponse(22, 3, 2, "Press after 2.2 seconds"),
            LevelResponse(23, 3, 3, "Press after 3.2 seconds"),
            LevelResponse(24, 3, 4, "Press after 4.2 seconds"),
            LevelResponse(25, 3, 5, "Press after 5.2 seconds"),
            LevelResponse(26, 3, 6, "Press after 6.2 seconds"),
            LevelResponse(27, 3, 7, "Press after 7.2 seconds"),
            LevelResponse(28, 3, 8, "Press after 8.2 seconds"),
            LevelResponse(29, 3, 9, "Press after 9.2 seconds"),
            LevelResponse(30, 3, 10, "Press after 10.2 seconds")
        )
    }
}
