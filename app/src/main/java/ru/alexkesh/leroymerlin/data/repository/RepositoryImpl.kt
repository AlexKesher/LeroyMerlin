package ru.alexkesh.leroymerlin.data.repository

import ru.alexkesh.leroymerlin.data.models.Group
import ru.alexkesh.leroymerlin.data.models.Product
import ru.alexkesh.leroymerlin.data.remote.ApiService

class RepositoryImpl(private val apiService: ApiService) : Repository {

    override fun getGroups(): List<Group> =
        apiService.getGroups()

    override fun getRecentlyWatchedProducts(): List<Product> =
        apiService.getRecentlyWatchedProducts()

    override fun getLimitedOfferProducts(): List<Product> =
        apiService.getLimitedOfferProducts()

    override fun getBestPriceProducts(): List<Product> =
        apiService.getBestPriceProducts()

}