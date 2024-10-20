package dev.rulsoft.oprbattles.club.domain

interface ClubSource {
    suspend fun fetchClubs(): List<Club>

    suspend fun fetchClubById(uid: String): Club?
}