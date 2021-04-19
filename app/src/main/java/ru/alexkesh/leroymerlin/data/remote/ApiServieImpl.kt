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
        val limitedOffersList = mutableListOf<Product>()
        for (i in 1..20) {
            val product = if (i % 2 == 0) {
                val price = (15..1100).random().toDouble()
                Product("Ламинат Artens \"Тангай\" ${32 + i} класс толщина 8 мм 1.986 м2", price,
                    R.drawable.laminat, "кор.")
            } else {
                val price = (15..2000).random().toDouble() + (0..99).random().toDouble() / 100
                Product("Дрель-шуруповерт аккумуляторная $i Bosch GSR 120, 12 В Li-oin 2x2 Ач",
                    price, R.drawable.drill, "шт.")
            }
            limitedOffersList.add(product)
        }
        return limitedOffersList.toList()
    }

    override fun getBestPriceProducts(): List<Product> {
        val bestPricesList = mutableListOf<Product>()
        for (i in 1..20) {
            val product = if (i % 2 == 0) {
                val price = (15..1100).random().toDouble() + (0..99).random().toDouble() / 100
                Product("Ламинат Artens \"Тангай\" ${20 + i} класс толщина 8 мм 1.986 м2", price,
                    R.drawable.laminat, "кор.")
            } else {
                val price = (15..2000).random().toDouble()
                Product("Дрель-шуруповерт аккумуляторная $i Bosch GSR 120, 12 В Li-oin 2x2 Ач",
                    price, R.drawable.drill, "шт.")
            }
            bestPricesList.add(product)
        }
        return bestPricesList.toList()
    }
}