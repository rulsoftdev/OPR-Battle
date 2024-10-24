package dev.rulsoft.oprbattles.presentation.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rulsoft.oprbattles.data.shop.networking.ShopDataSource
import dev.rulsoft.oprbattles.presentation.shop.models.toShopUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShopListViewModel: ViewModel() {

    private val repository = ShopDataSource()

    private val _state = MutableStateFlow(ShopListState())
    val state get() = _state.asStateFlow()

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = ShopListState(loading = true)
            val shops = repository.fetchShops()
            _state.value = ShopListState(loading = false, shops = shops.map { it.toShopUi() })
        }
    }

}