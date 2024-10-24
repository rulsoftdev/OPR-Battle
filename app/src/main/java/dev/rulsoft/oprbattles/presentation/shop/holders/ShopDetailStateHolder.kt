package dev.rulsoft.oprbattles.presentation.shop.holders

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

class ShopDetailStateHolder (
    val snackbarHostState: SnackbarHostState
){
    @Composable
    fun ShowMessageEffect(message: String?, onMessageShown: () -> Unit) {
        LaunchedEffect(message) {
            message?.let {
                snackbarHostState.currentSnackbarData?.dismiss()
                snackbarHostState.showSnackbar(it)
                onMessageShown()
            }
        }
    }
}

@Composable
fun rememberShopDetailStateHolder(
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
): ShopDetailStateHolder {
    return remember(snackbarHostState) { ShopDetailStateHolder(snackbarHostState = snackbarHostState) }
}