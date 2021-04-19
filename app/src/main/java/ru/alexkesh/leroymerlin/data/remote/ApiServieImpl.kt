package ru.alexkesh.leroymerlin.data.remote

import ru.alexkesh.leroymerlin.R
import ru.alexkesh.leroymerlin.data.models.Group
import ru.alexkesh.leroymerlin.data.models.Product
import java.util.*

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
        return listOf(
            Product("Ламинат Artens \"Тангай\" 33 класс толщина 8 мм 1.986 м2", 930.60,
                R.drawable.laminat, "кор."),
            Product("Ламинат Artens \"Тангай\" 34 класс толщина 8 мм 1.986 м2", 556.0,
                R.drawable.laminat, "кор."),
            Product("Ламинат Artens \"Тангай\" 35 класс толщина 8 мм 1.986 м2", 93.14,
                R.drawable.laminat, "кор."),
            Product("Ламинат Artens \"Тангай\" 36 класс толщина 8 мм 1.986 м2", 1930.75,
                R.drawable.laminat, "кор."),
            Product("Ламинат Artens \"Тангай\" 37 класс толщина 8 мм 1.986 м2", 930.60,
                R.drawable.laminat, "кор.")
        )
    }

    override fun getLimitedOfferProducts(): List<Product> {
        TODO("Not yet implemented")
    }

    override fun getBestPriceProducts(): List<Product> {
        TODO("Not yet implemented")
    }
}