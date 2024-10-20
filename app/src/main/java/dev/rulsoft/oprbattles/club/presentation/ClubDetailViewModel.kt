package dev.rulsoft.oprbattles.club.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rulsoft.oprbattles.core.navigation.NavArg
import dev.rulsoft.oprbattles.club.data.networking.ClubDataSource
import dev.rulsoft.oprbattles.club.presentation.models.ClubUi
import dev.rulsoft.oprbattles.club.presentation.models.toClubUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClubDetailViewModel
@Inject
constructor(
    private val repository: ClubDataSource,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val uid = savedStateHandle.get<String>(NavArg.UId.key) ?: ""

    private val _state = MutableStateFlow(UiState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            val club = repository.fetchClubById(uid)
            if (club != null) {
                _state.value = UiState(loading = false, club = club.toClubUi())
            } else {
                _state.value = UiState(loading = false)
            }
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val club: ClubUi? = null
    )
}