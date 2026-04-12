package de.hwr.pressregret.service

import de.hwr.pressregret.api.response.AchievementResponse
import org.springframework.stereotype.Service

/**
 * Service managing the achievement system.
 *
 * Achievements are unlocked automatically when specific levels are completed.
 * The unlock state is stored in-memory per session. Achievements reset on server restart.
 */
@Service
class AchievementService {

    // Set of achievement IDs that have been unlocked in the current session.
    private val unlockedAchievements = mutableSetOf<Int>()


    //Returns all achievements with their current unlock status.
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

    /**
     * Manually updates the unlock state of a specific achievement.
     * Used by the Frontend to explicitly lock or unlock an achievement.
     */
    fun update(achievementId: Int, unlocked: Boolean): AchievementResponse {
        if (unlocked) unlockedAchievements.add(achievementId)
        else unlockedAchievements.remove(achievementId)

        return getAchievements().firstOrNull { it.id == achievementId }
            ?: throw IllegalArgumentException("Achievement $achievementId not found")
    }

    //Internally unlocks an achievement by adding its ID to the unlocked set
    private fun unlock(achievementId: Int) {
        unlockedAchievements.add(achievementId)
    }

    /**
     * Checks whether completing the given level triggers an achievement unlock.
     * Each achievement is only unlocked once. Subsequent completions of the same level are ignored.
     */
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