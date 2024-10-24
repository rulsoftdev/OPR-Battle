package dev.rulsoft.oprbattles.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.rulsoft.oprbattles.core.navigation.graphs.ClubGraph
import dev.rulsoft.oprbattles.core.navigation.graphs.clubGraph
import dev.rulsoft.oprbattles.core.navigation.graphs.shopGraph

private const val TAG = "Navigation"

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController,  startDestination = ClubGraph){
        clubGraph(navController)
        shopGraph(navController)
    }
}

