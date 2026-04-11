package com.technical.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material3.*
import androidx.compose.ui.Modifier

@Composable
fun CharacterScreen(viewModel: CharactersViewModel = hiltViewModel()) {

    val state by viewModel.ui.collectAsState()

    when (state) {
        is UIState.Loading -> {
            CircularProgressIndicator()
        }

        is UIState.Error -> {
            Column{
                Text("")
            }
        }

        is UIState.Success -> {

        }
    }
}