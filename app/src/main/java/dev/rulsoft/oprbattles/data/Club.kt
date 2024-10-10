package dev.rulsoft.oprbattles.data

import java.util.Date

data class Club(
    val uid: String = "",
    val displayName: String = "",
    val email: String = "",
    val photoURL: String = "",
    val phone: String = "",
    val address: String = "",
    val createdDate: Date? = null,
    val lastAccess: Date? = null,
    val members: List<String> = emptyList()
)
