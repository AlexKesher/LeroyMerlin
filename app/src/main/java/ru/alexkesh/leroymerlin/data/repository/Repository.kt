package ru.alexkesh.leroymerlin.data.repository

import ru.alexkesh.leroymerlin.data.models.Group
import ru.alexkesh.leroymerlin.data.models.Product

interface Repository {
    fun getGroups(): List<Group>
    fun getRecentlyWatchedProducts(): List<Product>
    fun getLimitedOfferProducts(): List<Product>
    fun getBestPriceProducts(): List<Product>
}