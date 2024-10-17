package dev.rulsoft.oprbattles.ui.screen.shop

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rulsoft.oprbattles.data.Club
import dev.rulsoft.oprbattles.data.Shop
import dev.rulsoft.oprbattles.navigations.NavArg
import dev.rulsoft.oprbattles.repository.ClubRepository
import dev.rulsoft.oprbattles.repository.ShopRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopDetailViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var repository =  ShopRepository()

    private val uid = savedStateHandle.get<String>(NavArg.UId.key) ?: ""

    private val _state = MutableStateFlow(UiState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(loading = false, shop = repository.fetchShopById(uid))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val shop: Shop? = null
    )
}