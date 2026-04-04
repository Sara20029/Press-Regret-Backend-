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
            LevelResponse(1, 1, 1, "Press Button"),
            LevelResponse(2, 1, 2, "Do not Press Button"),
            LevelResponse(3, 1, 3, "Remember number x"),
            LevelResponse(4, 1, 4, "Press and Hold Button"),
            LevelResponse(5, 1, 5, "Press x times")
        )
    }

    private fun getMediumLevels(): List<LevelResponse> {
        return listOf(
            LevelResponse(11, 2, 1, "Do not Press when you see a rat"),
            LevelResponse(12, 2, 2, "Press per corner"),
            LevelResponse(13, 2, 3, "Press when cats are odd"),
            LevelResponse(14, 2, 4, "Press Button"), //Ratten Foto
            LevelResponse(15, 2, 5, "The next Statement is a lie")
        )
    }

    private fun getHardLevels(): List<LevelResponse> {
        return listOf(
            LevelResponse(21, 3, 1, "Press per corner"), //darf nicht exakt drücken, wegen vorheriger Aussage, entweder mehr oder weniger
            LevelResponse(22, 3, 2, "Katze"), //Bild von 5 Katzen mit Ratte in der Ecke
            LevelResponse(23, 3, 3, "Mathe"), //Mathe Gleichung sehe OneNote
            LevelResponse(24, 3, 4, "Pres as the remembered number"),
            LevelResponse(25, 3, 5, "Press 100 times")
        )
    }
}
