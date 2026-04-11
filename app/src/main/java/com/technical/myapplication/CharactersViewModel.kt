package com.technical.myapplication
import androidx.lifecycle.ViewModel
import com.technical.domain.CharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacters: CharactersUseCase
) : ViewModel() {

    private val _ui = MutableStateFlow<UIState>(UIState.Loading)
    val ui: StateFlow<UIState> = _ui.asStateFlow()

    fun load(page: Int = 1) = viewModelScope.launch {
        _ui.value = UIState.Loading

        try {
            val result = getCharacters.getCharacter(page)
            _ui.value = UIState.Success(result.getOrThrow())
        } catch (ex: Exception) {
            _ui.value = UIState.Error(ex.message ?: "Error")
        }
    }
}