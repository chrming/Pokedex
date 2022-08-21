package com.example.pokedex.screens.pokemonList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.screens.destinations.PokemonDetailScreenDestination
import com.example.pokedex.screens.pokemonList.domain.PokemonListVM
import com.example.pokedex.screens.pokemonList.ui.composable.PokemonVerticalGrid
import com.example.pokedex.screens.pokemonList.ui.composable.SelectTypeLazyRow
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PokemonListScreen(
    viewModel: PokemonListVM = hiltViewModel(),
    navigator: DestinationsNavigator,
) {
    val pokemonListState = viewModel.pokemonListState.value
    val pokemonGridState = viewModel.pokemonGridState
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SelectTypeLazyRow(onItemClick = {})
        PokemonVerticalGrid(
            modifier = Modifier,
            pokemonList = pokemonListState.pokemonList,
            pokemonGridState = pokemonGridState,
            onItemClick = { pokemon ->
                navigator.navigate(PokemonDetailScreenDestination(pokemon.name))
            }
        )
    }
}

