package dev.rulsoft.oprbattles.ui.composable.common.topBars

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailAppBar(
    title: @Composable () -> Unit,
    descriptionBack: String,
    onClickBack: () -> Unit
) {
    TopAppBar(
        title = title,
        navigationIcon = {
            ArrowBackIcon(description = descriptionBack) {
                onClickBack()
            }
        }
    )
}