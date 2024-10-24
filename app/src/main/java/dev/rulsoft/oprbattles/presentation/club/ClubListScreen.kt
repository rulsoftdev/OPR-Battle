package dev.rulsoft.oprbattles.presentation.club

import androidx.compose.runtime.Composable
import dev.rulsoft.oprbattles.presentation.club.models.ClubUi
import dev.rulsoft.oprbattles.ui.composable.ClubList

@Composable
fun ClubListScreen(onClubClick: (ClubUi) -> Unit) {
    ClubList(
        onClubClick = onClubClick
    )
}

