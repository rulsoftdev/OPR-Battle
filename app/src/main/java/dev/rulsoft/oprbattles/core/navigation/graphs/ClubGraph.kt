package dev.rulsoft.oprbattles.core.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.rulsoft.oprbattles.club.presentation.ClubDetailScreen
import dev.rulsoft.oprbattles.club.presentation.ClubListScreen
import dev.rulsoft.oprbattles.core.navigation.ClubNav
import dev.rulsoft.oprbattles.core.navigation.ClubsNav
import kotlinx.serialization.Serializable

@Serializable
object ClubGraph

fun NavGraphBuilder.clubGraph(navController: NavHostController){
    navigation<ClubGraph>(startDestination = ClubsNav) {
        composable<ClubsNav> {
            ClubListScreen(
                onClubClick = { club ->
                    navController.navigate(ClubNav(club.uid))
                }
            )
        }
        composable<ClubNav> {
            ClubDetailScreen()
        }
    }

}