package dev.rulsoft.oprbattles.user.domain

import java.util.Date

data class User(
    val uid: String = "",
    val displayName: String = "",
    val email: String = "",
    val photoURL: String = "",
    val fcmToken: String = "",
    val plays: Int = 0,
    val winRate: Double = 0.0,
    val genere: Genere = Genere.NINGUNO,
    val birthdate: Date?= null,
    val createdDate: Date? = null,
    val lastAccess: Date? = null,
    val rosters: List<String> = emptyList()
)