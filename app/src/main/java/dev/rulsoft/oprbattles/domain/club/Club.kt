package dev.rulsoft.oprbattles.domain.club

data class Club(
    val uid: String,
    val displayName: String,
    val descripcion: String,
    val email: String,
    val backdrop: String,
    val photoURL: String,
    val phone: String,
    val address: String,
    val members: List<String>
)
