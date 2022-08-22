package com.example.pokedex.screens.pokemonList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.screens.destinations.PokemonDetailScreenDestination
import com.example.pokedex.screens.pokemonList.domain.PokemonListVM
import com.example.pokedex.screens.pokemonList.ui.composable.filter.FiltersSection
import com.example.pokedex.screens.pokemonList.ui.composable.PokemonVerticalGrid
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
    val filterState = viewModel.filterState

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        FiltersSection(Modifier.fillMaxWidth(), filterState, onEvent = { event ->
            viewModel.onEvent(event)
        } )
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

