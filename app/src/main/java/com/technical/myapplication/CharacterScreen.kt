package com.technical.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material3.*
import com.technical.domain.CharacterModel

@Composable
fun CharacterScreen(viewModel: CharactersViewModel = hiltViewModel()) {

    val state by viewModel.ui.collectAsState()

    when (state) {
        is UIState.Loading -> {
            CircularProgressIndicator()
        }

        is UIState.Error -> {
            Column {
                Text("")
            }
        }

        is UIState.Success -> {
            val list = (state as UIState.Success).items
            LazyColumn {
                items(list) { item: CharacterModel ->
                    Row {
                        /*AsyncImage(
                            model = item.image,
                            contentDescription = item.name
                        )*/
                        Column {
                            Text(item.name ?: "name")
                            Text(item.status ?: "status")
                        }
                    }
                }
            }
        }
    }
}