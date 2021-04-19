package ru.alexkesh.leroymerlin.data.models

import androidx.annotation.DrawableRes
import java.util.*

data class Product(
    val title: String,
    val pricePerUnit: Double,
    @DrawableRes val imgRes: Int,
    val unitName: String,
    val currency: String = "\u20bd"
)