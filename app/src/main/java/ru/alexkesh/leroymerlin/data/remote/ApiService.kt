package ru.alexkesh.leroymerlin.data.remote

import ru.alexkesh.leroymerlin.data.models.Group
import ru.alexkesh.leroymerlin.data.models.Product

interface ApiService {
    fun getGroups(): List<Group>
    fun getRecentlyWatchedProducts(): List<Product>
    fun getLimitedOfferProducts(): List<Product>
    fun getBestPriceProducts(): List<Product>
}