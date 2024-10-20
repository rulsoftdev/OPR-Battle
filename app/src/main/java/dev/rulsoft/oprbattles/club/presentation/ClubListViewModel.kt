package dev.rulsoft.oprbattles.club.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rulsoft.oprbattles.club.data.networking.ClubDataSource
import dev.rulsoft.oprbattles.club.presentation.models.toClubUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "ClubListViewModel"

@HiltViewModel
class ClubListViewModel
@Inject constructor(
    private val repository: ClubDataSource
): ViewModel() {

    private val _state = MutableStateFlow(ClubListState())
    val state get() = _state.asStateFlow()

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = ClubListState(loading = true)
            val clubs = repository.fetchClubs().map { club -> club.toClubUi() }
            _state.value = ClubListState(loading = false, clubs = clubs)
        }

    }

}