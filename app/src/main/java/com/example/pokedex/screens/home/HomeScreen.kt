package com.example.pokedex.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.pokedex.screens.destinations.PokemonListScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    Column() {
        Button(onClick = { navigator.navigate(PokemonListScreenDestination) }) {
            Text(text = "Pokemon List")
        }
    }
}
