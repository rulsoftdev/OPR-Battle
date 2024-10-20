package dev.rulsoft.oprbattles.core.navigation.composable

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.rulsoft.oprbattles.core.navigation.NavItem

@Composable
fun AppBottomNavigation(
    bottomNavOptions: List<NavItem>,
    currentRoute: String,
    onNavItemClick: (NavItem) -> Unit
) {
    OPRBattlesBottomNavigation {
        bottomNavOptions.forEach { item ->
            val title = stringResource(id = item.title)
            NavigationBarItem(
                selected = currentRoute.contains(item.navCommand.feature.route),
                onClick = { onNavItemClick(item) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = title
                    )
                },
                label = { Text(text = title) }
            )
        }
    }
}