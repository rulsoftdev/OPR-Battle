package dev.rulsoft.oprbattles.core.navigation.composable

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import dev.rulsoft.oprbattles.core.navigation.NavItem

@Composable
fun AppBottomNavigation(
    bottomNavOptions: List<NavItem>,
    currentDestination: NavDestination?,
    onNavItemClick: (NavItem) -> Unit
) {
    OPRBattlesBottomNavigation {
        bottomNavOptions.forEach { item ->
            val title = stringResource(id = item.navCommand.title)
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any {
                    it.hasRoute(item.navCommand.route::class)
                } == true,
                onClick = { onNavItemClick(item) },
                icon = {
                    if (item.icon != null) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = title
                        )
                    }
                },
                label = { Text(text = title) }
            )
        }
    }
}