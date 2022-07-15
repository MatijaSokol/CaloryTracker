package com.matijasokol.tracker_data.mapper

import com.matijasokol.tracker_data.remote.dto.Product
import com.matijasokol.tracker_domain.model.TrackableFood
import kotlin.math.roundToInt

fun Product.toTrackableFood(): TrackableFood? {
    return TrackableFood(
        name = productName ?: return null,
        carbsPer100g = nutriments.carbohydrates100g.roundToInt(),
        proteinPer100g = nutriments.proteins100g.roundToInt(),
        fatPer100g = nutriments.fat100g.roundToInt(),
        caloriesPer100g = nutriments.energyKcal100g.roundToInt(),
        imageUrl = imageFrontThumbUrl
    )
}