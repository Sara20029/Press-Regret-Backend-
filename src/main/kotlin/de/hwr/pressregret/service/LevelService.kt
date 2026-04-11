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
            else -> throw NoSuchElementException("Difficulty $difficultyId not found")
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
            LevelResponse(2, 1, 2, "Do not Press Button", "DO_NOT_PRESS", 0),
            LevelResponse(3, 1, 3, "Press and Hold Button", "HOLD"),
            LevelResponse(4, 1, 4, "Remember number 29", "READ_ONLY"),
            LevelResponse(5, 1, 5, "Press 5 times", "PRESS_X_TIMES", 5)
        )
    }

    private fun getMediumLevels(): List<LevelResponse> {
        return listOf(
            LevelResponse(11, 2, 1, "Do not Press when you see a rat", "DO_NOT_PRESS", null, "rat.png"),
            LevelResponse(12, 2, 2, "Press per corner", "PRESS_X_TIMES", 10, "star.png"),
            LevelResponse(13, 2, 3, "Press when cats are odd", "READ_ONLY"),
            LevelResponse(14, 2, 4, "Press Button", "DO_NOT_PRESS", null, "rat.png"),
            LevelResponse(15, 2, 5, "The next Statement is a lie", "READ_ONLY")
        )
    }

    private fun getHardLevels(): List<LevelResponse> {
        return listOf(
            LevelResponse(21, 3, 1, "Press Button", "DO_NOT_PRESS", null),
            LevelResponse(22, 3, 2, "", "PRESS", 1, "cat.png"),
            LevelResponse(23, 3, 3, "3 * (8 - 2) - 4 = ?", "PRESS_X_TIMES", 14),
            LevelResponse(24, 3, 4, "Pres as the remembered number", "PRESS_X_TIMES", 29),
            LevelResponse(25, 3, 5, "Press 100 times", "PRESS_X_TIMES", 100)
        )
    }


}