package dev.rulsoft.oprbattles.repository

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import dev.rulsoft.oprbattles.data.Shop
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

private const val TAG = "ShopRepository"

class ShopRepository {

    suspend fun fetchShops(): List<Shop> = withContext(Dispatchers.IO) {
        val db = Firebase.firestore
        return@withContext try {
            db.collection("Shops")
                .get()
                .await()
                .documents
                .mapNotNull { document ->
                    document.toObject(Shop::class.java)
                }
        } catch (e: Exception) {
            Log.w(TAG, "Error fetching clubs: ${e.message}", e)
            emptyList()
        }
    }

    suspend fun fetchShopById(uid: String): Shop? = withContext(Dispatchers.IO) {
        val db = Firebase.firestore
        return@withContext try {
            db.collection("Shops")
                .document(uid)
                .get()
                .await()
                .toObject(Shop::class.java)
        } catch (e: Exception) {
            Log.w(TAG, "Error fetching club with ID $uid: ${e.message}", e)
            null
        }
    }

}