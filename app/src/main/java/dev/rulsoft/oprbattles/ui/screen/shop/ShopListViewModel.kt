package dev.rulsoft.oprbattles.ui.screen.shop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rulsoft.oprbattles.data.model.Shop
import dev.rulsoft.oprbattles.domain.ShopDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShopListViewModel: ViewModel() {

    private val repository = ShopDataRepository()

    private val _state = MutableStateFlow(UiState())
    val state get() = _state.asStateFlow()

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            val shops = repository.fetchShops()
            _state.value = UiState(loading = false, shops = shops)
        }

    }

    data class UiState(
        val loading: Boolean = false,
        val shops: List<Shop> = emptyList()
    )

}