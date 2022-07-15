package com.matijasokol.core.data.preferences

import android.content.SharedPreferences
import com.matijasokol.core.domain.model.ActivityLevel
import com.matijasokol.core.domain.model.Gender
import com.matijasokol.core.domain.model.GoalType
import com.matijasokol.core.domain.model.UserInfo
import com.matijasokol.core.domain.preferences.Preferences
import com.matijasokol.core.domain.preferences.Preferences.Companion.KEY_ACTIVITY_LEVEL
import com.matijasokol.core.domain.preferences.Preferences.Companion.KEY_AGE
import com.matijasokol.core.domain.preferences.Preferences.Companion.KEY_CARB_RATIO
import com.matijasokol.core.domain.preferences.Preferences.Companion.KEY_FAT_RATIO
import com.matijasokol.core.domain.preferences.Preferences.Companion.KEY_GENDER
import com.matijasokol.core.domain.preferences.Preferences.Companion.KEY_GOAL_TYPE
import com.matijasokol.core.domain.preferences.Preferences.Companion.KEY_HEIGHT
import com.matijasokol.core.domain.preferences.Preferences.Companion.KEY_PROTEIN_RATIO
import com.matijasokol.core.domain.preferences.Preferences.Companion.KEY_SHOULD_SHOW_ONBOARDING
import com.matijasokol.core.domain.preferences.Preferences.Companion.KEY_WEIGHT

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
) : Preferences {

    override fun saveGender(gender: Gender) {
        sharedPreferences.edit().putString(KEY_GENDER, gender.name).apply()
    }

    override fun saveAge(age: Int) {
        sharedPreferences.edit().putInt(KEY_AGE, age).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPreferences.edit().putFloat(KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Int) {
        sharedPreferences.edit().putInt(KEY_HEIGHT, height).apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPreferences.edit().putString(KEY_ACTIVITY_LEVEL, level.name).apply()
    }

    override fun saveGoalType(type: GoalType) {
        sharedPreferences.edit().putString(KEY_GOAL_TYPE, type.name).apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPreferences.edit().putFloat(KEY_CARB_RATIO, ratio).apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPreferences.edit().putFloat(KEY_PROTEIN_RATIO, ratio).apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPreferences.edit().putFloat(KEY_FAT_RATIO, ratio).apply()
    }

    override fun loadUserInfo(): UserInfo {
        return UserInfo(
            gender = Gender.fromString(sharedPreferences.getString(KEY_GENDER, null)),
            age = sharedPreferences.getInt(KEY_AGE, -1),
            weight = sharedPreferences.getFloat(KEY_WEIGHT, -1f),
            height = sharedPreferences.getInt(KEY_HEIGHT, -1),
            activityLevel = ActivityLevel.fromString(sharedPreferences.getString(KEY_ACTIVITY_LEVEL, null)),
            goalType = GoalType.fromString(sharedPreferences.getString(KEY_GOAL_TYPE, null)),
            carbRatio = sharedPreferences.getFloat(KEY_CARB_RATIO, -1f),
            proteinRatio = sharedPreferences.getFloat(KEY_PROTEIN_RATIO, -1f),
            fatRatio = sharedPreferences.getFloat(KEY_FAT_RATIO, -1f)
        )
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_SHOULD_SHOW_ONBOARDING, shouldShow).apply()
    }

    override fun loadShouldShowOnBoarding(): Boolean {
        return sharedPreferences.getBoolean(KEY_SHOULD_SHOW_ONBOARDING, true)
    }
}