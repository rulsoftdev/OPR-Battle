package dev.rulsoft.oprbattles.shop.domain

interface ShopData {
    suspend fun fetchShops(): List<Shop>

    suspend fun fetchShopById(uid: String): Shop?
}