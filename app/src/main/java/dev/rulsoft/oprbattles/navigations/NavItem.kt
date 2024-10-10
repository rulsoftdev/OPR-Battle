package dev.rulsoft.oprbattles.navigations

import androidx.annotation.StringRes
import androidx.navigation.NavType
import androidx.navigation.navArgument
import dev.rulsoft.oprbattles.R

sealed class NavItem(
    val baseRoute: String,
    @StringRes val title: Int,
    private val navArgs: List<NavArg> = emptyList()
){
    val route = run {
        // baseroute/{arg1}/{arg2} ....
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }
    val args = navArgs.map {
        navArgument(it.key) { it.navType }
    }

    data object ClubList : NavItem("clubList", R.string.app_title)
    data object ClubDetail: NavItem("clubDetail", R.string.title_club_detail, listOf(NavArg.ClubId)){
        fun createNavRoute(clubId: String) = "$baseRoute/$clubId"
    }
}

enum class NavArg (val key: String, val navType: NavType<*>){
    ClubId("clubId", NavType.StringType)
}