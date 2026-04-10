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

    fun checkAndUnlock(levelId: Int){
        when(levelId){
            1 -> unlock(1)
            5 -> unlock(2)
            15 -> unlock(3)
            25 -> unlock(4)
        }
    }


}