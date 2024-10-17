package dev.rulsoft.oprbattles.ui.screen.club

import androidx.compose.runtime.Composable
import dev.rulsoft.oprbattles.data.Club
import dev.rulsoft.oprbattles.ui.composable.ClubList

@Composable
fun ClubListScreen(onClubClick: (Club) -> Unit) {
    ClubList(
        onClubClick = onClubClick
    )
}

