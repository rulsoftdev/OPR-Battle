package dev.rulsoft.oprbattles.ui.screen.club

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rulsoft.oprbattles.data.Club
import dev.rulsoft.oprbattles.repository.ClubRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "ClubListViewModel"

@HiltViewModel
class ClubListViewModel
@Inject constructor(
    private val repository: ClubRepository
): ViewModel() {


    private val _state = MutableStateFlow(UiState())
    val state get() = _state.asStateFlow()

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            val clubs = repository.fetchClubs()
            _state.value = UiState(loading = false, clubs = clubs)
        }

    }

    data class UiState(
        val loading: Boolean = false,
        val clubs: List<Club> = emptyList()
    )

}