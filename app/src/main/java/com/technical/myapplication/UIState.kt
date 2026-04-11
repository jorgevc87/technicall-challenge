package com.technical.myapplication

import com.technical.domain.CharacterModel

sealed class UIState {
    object Loading : UIState()
    data class Success(val items: List<CharacterModel>) : UIState()
    data class Error(val message: String) : UIState()
}