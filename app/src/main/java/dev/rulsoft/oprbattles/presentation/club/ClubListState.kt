package dev.rulsoft.oprbattles.presentation.club

import androidx.compose.runtime.Immutable
import dev.rulsoft.oprbattles.presentation.club.models.ClubUi

@Immutable
data class ClubListState (
    val loading: Boolean = false,
    val clubs: List<ClubUi> = emptyList()
)