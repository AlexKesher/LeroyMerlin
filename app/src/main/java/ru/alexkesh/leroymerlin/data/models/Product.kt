package ru.alexkesh.leroymerlin.data.models

import androidx.annotation.DrawableRes

data class Product(
    val title: String,
    val pricePerUnit: Double,
    @DrawableRes val imgRes: Int,
    val unitNameRes: String
)