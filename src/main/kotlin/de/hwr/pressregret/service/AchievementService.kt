package de.hwr.pressregret.service

import de.hwr.pressregret.api.response.AchievementResponse
import org.springframework.stereotype.Service


@Service
class AchievementService {

    private val unlockedAchievements = mutableSetOf<Int>()

    fun getAchievements() = listOf(
        AchievementResponse(
            id = 1,
            key = "firstLevel",
            title = "First Level",
            description = "Complete the first level!",
            unlocked = unlockedAchievements.contains(1),
        ),
        AchievementResponse(
            id = 2,
            key = "easyDifficulty",
            title = "Easy Difficulty",
            description = "Complete all levels in difficulty easy!",
            unlocked = unlockedAchievements.contains(2),
        ),
        AchievementResponse(
            id = 3,
            key = "mediumDifficulty",
            title = "Medium Difficulty",
            description = "Complete all levels in difficulty Medium!",
            unlocked = unlockedAchievements.contains(3)
        ),
        AchievementResponse(
            id = 4,
            key = "hardDifficulty",
            title = "Hard Difficulty",
            description = "Complete all levels in difficulty hard!",
            unlocked = unlockedAchievements.contains(4),
        )
    )

    fun unlock(achievementId: Int) {
        unlockedAchievements.add(achievementId)
    }

    fun checkAndUnlock(levelId: Int): String? {
        return when(levelId){
            1 -> if (!unlockedAchievements.contains(1)) { unlock(1); "firstLevel"} else null
            5 -> if (!unlockedAchievements.contains(2)) { unlock(2); "easyDifficulty"} else null
            15 -> if (!unlockedAchievements.contains(3)) { unlock(3); "mediumDifficulty"} else null
            25 -> if (!unlockedAchievements.contains(4)) { unlock(4); "hardDifficulty"} else null
            else -> null
        }
    }


}