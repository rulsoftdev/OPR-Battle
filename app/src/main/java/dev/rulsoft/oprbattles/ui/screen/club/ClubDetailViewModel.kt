package dev.rulsoft.oprbattles.ui.screen.club

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rulsoft.oprbattles.data.Club
import dev.rulsoft.oprbattles.navigations.NavArg
import dev.rulsoft.oprbattles.repository.ClubRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClubDetailViewModel
@Inject
constructor(
    private val repository: ClubRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val uid = savedStateHandle.get<String>(NavArg.UId.key) ?: ""

    private val _state = MutableStateFlow(UiState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(loading = false, club = repository.fetchClubById(uid))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val club: Club? = null
    )
}