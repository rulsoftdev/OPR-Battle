package dev.rulsoft.oprbattles.data.club.networking

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dev.rulsoft.oprbattles.domain.club.Club
import dev.rulsoft.oprbattles.domain.club.ClubSource
import dev.rulsoft.oprbattles.data.club.networking.dto.ClubDto
import dev.rulsoft.oprbattles.data.club.mappers.toClub
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val TAG = "ClubRepository"

class ClubDataSource
@Inject constructor(
    private val db: FirebaseFirestore
) : ClubSource {

    override suspend fun fetchClubs(): List<Club> = withContext(Dispatchers.IO) {

        return@withContext try {
            val clubDtos = db.collection("Clubs")
                .get()
                .await()
                .documents
                .mapNotNull { document ->
                    document.toObject(ClubDto::class.java)
                }

            clubDtos.map { clubDto ->
                clubDto.toClub()
            }
        } catch (e: Exception) {
            Log.w(TAG, "Error fetching clubs: ${e.message}", e)
            emptyList()
        }
    }

    override suspend fun fetchClubById(uid: String): Club? = withContext(Dispatchers.IO) {
        val db = Firebase.firestore
        return@withContext try {
            val clubDto = db.collection("Clubs")
                .document(uid)
                .get()
                .await()
                .toObject(ClubDto::class.java)

            if (clubDto == null) {
                return@withContext null
            }
            clubDto.toClub()
        } catch (e: Exception) {
            Log.w(TAG, "Error fetching club with ID $uid: ${e.message}", e)
            null
        }
    }

}