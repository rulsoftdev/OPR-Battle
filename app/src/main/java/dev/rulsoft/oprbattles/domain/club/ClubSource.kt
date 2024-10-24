package dev.rulsoft.oprbattles.domain.club

interface ClubSource {
    suspend fun fetchClubs(): List<Club>

    suspend fun fetchClubById(uid: String): Club?
}