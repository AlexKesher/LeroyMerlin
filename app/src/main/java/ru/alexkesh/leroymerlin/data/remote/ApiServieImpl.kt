package ru.alexkesh.leroymerlin.data.remote

import ru.alexkesh.leroymerlin.R
import ru.alexkesh.leroymerlin.data.models.Group
import ru.alexkesh.leroymerlin.data.models.Product

class ApiServiceImpl : ApiService {
    override fun getGroups(): List<Group> {
        return listOf(
            Group("Каталог", R.drawable.ic_list_for_card),
            Group("Сад", R.drawable.drill),
            Group("Освещение", R.drawable.drill),
            Group("Инструменты", R.drawable.drill),
            Group("Стройматериалы", R.drawable.drill),
            Group("Декор", R.drawable.drill),
            Group("Смотреть всё", R.drawable.ic_watch_all),
        )
    }

    override fun getRecentlyWatchedProducts(): List<Product> {
        TODO("Not yet implemented")
    }

    override fun getLimitedOfferProducts(): List<Product> {
        TODO("Not yet implemented")
    }

    override fun getBestPriceProducts(): List<Product> {
        TODO("Not yet implemented")
    }
}