package de.hwr.pressregret.service

import de.hwr.pressregret.api.response.LevelResponse
import org.springframework.stereotype.Service

@Service
class LevelService {

    fun getLevelsByDifficulty(difficultyId: Int): List<LevelResponse> {
        return when (difficultyId) {
            1 -> getEasyLevels()
            2 -> getMediumLevels()
            3 -> getHardLevels()
            else -> throw IllegalArgumentException("Invalid difficultyId: $difficultyId")
        }
    }

    fun getLevelById(levelId: Int): LevelResponse? {
        return getAllLevels().find { it.levelId == levelId }
    }


    fun getAllLevels(): List<LevelResponse> {
        return getEasyLevels() + getMediumLevels() + getHardLevels()
    }

    private fun getEasyLevels(): List<LevelResponse> {
        return listOf(
            LevelResponse(1, 1, 1, "Press Button", "PRESS", 1),
            LevelResponse(2, 1, 2, "Do not Press Button", "DO_NOT_PRESS"),
            LevelResponse(3, 1, 3, "Remember number 52", "READ_ONLY"),
            LevelResponse(4, 1, 4, "Press and Hold Button", "HOLD"),
            LevelResponse(5, 1, 5, "Press x times", "PRESS_X_TIMES", 5)
        )
    }

    private fun getMediumLevels(): List<LevelResponse> {
        return listOf(
            LevelResponse(11, 2, 1, "Do not Press when you see a rat", "DO_NOT_PRESS"),
            LevelResponse(12, 2, 2, "Press per corner", "PRESS_X_TIMES", 4),
            LevelResponse(13, 2, 3, "Press when cats are odd", "READ_ONLY"),
            LevelResponse(14, 2, 4, "Press Button", "DO_NOT_PRESS"), //Ratten Foto
            LevelResponse(15, 2, 5, "The next Statement is a lie", "READ_ONLY")
        )
    }

    private fun getHardLevels(): List<LevelResponse> {
        return listOf(
            LevelResponse(21, 3, 1, "Press per corner", "NOT_X_TIMES", 4), //darf nicht exakt drücken, wegen vorheriger Aussage, entweder mehr oder weniger
            LevelResponse(22, 3, 2, "Katze", "DO_NOT_PRESS"), //Bild von 5 Katzen mit Ratte in der Ecke
            LevelResponse(23, 3, 3, "Mathe", "PRESS_X_TIMES", 10), //Mathe Gleichung sehe OneNote
            LevelResponse(24, 3, 4, "Pres as the remembered number", "PRESS_X_TIMES", 52),
            LevelResponse(25, 3, 5, "Press 100 times", "PRESS_X_TIMES", 100)
        )
    }


}