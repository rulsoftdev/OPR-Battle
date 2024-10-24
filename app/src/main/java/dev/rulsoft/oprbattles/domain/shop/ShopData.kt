package dev.rulsoft.oprbattles.domain.shop

interface ShopData {
    suspend fun fetchShops(): List<Shop>

    suspend fun fetchShopById(uid: String): Shop?
}