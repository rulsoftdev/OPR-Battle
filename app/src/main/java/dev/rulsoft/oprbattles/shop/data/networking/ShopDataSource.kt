package dev.rulsoft.oprbattles.shop.data.networking

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import dev.rulsoft.oprbattles.shop.data.mappers.toShop
import dev.rulsoft.oprbattles.shop.data.networking.dto.ShopDto
import dev.rulsoft.oprbattles.shop.domain.ShopData
import dev.rulsoft.oprbattles.shop.domain.Shop
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

private const val TAG = "ShopRepository"

class ShopDataSource : ShopData {

    override suspend fun fetchShops(): List<Shop> = withContext(Dispatchers.IO) {
        val db = Firebase.firestore
        try {
            val shopsDto =db.collection("Shops")
                .get()
                .await()
                .documents
                .mapNotNull { document ->
                    document.toObject(ShopDto::class.java)
                }
            return@withContext shopsDto.map { shopDto -> shopDto.toShop() }
        } catch (e: Exception) {
            Log.w(TAG, "Error fetching clubs: ${e.message}", e)
            emptyList()
        }
    }

    override suspend fun fetchShopById(uid: String): Shop? = withContext(Dispatchers.IO) {
        val db = Firebase.firestore
        try {
            val shopDto = db.collection("Shops")
                .document(uid)
                .get()
                .await()
                .toObject(ShopDto::class.java)
            if (shopDto == null) {
                return@withContext null
            }
            return@withContext shopDto.toShop()
        } catch (e: Exception) {
            Log.w(TAG, "Error fetching club with ID $uid: ${e.message}", e)
            null
        }
    }

}