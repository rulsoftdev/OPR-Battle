package dev.rulsoft.oprbattles.data

import dev.rulsoft.oprbattles.data.model.Shop

interface ShopRepository {
    suspend fun fetchShops(): List<Shop>

    suspend fun fetchShopById(uid: String): Shop?
}