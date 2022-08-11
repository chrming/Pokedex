package com.example.pokedex.pokemonList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.pokemonList.domain.PokemonListVM
import com.example.pokedex.pokemonList.ui.composable.PokemonVerticalGrid
import com.example.pokedex.pokemonList.ui.composable.SelectTypeLazyRow

@Composable
fun PokemonListScreen(
    viewModel: PokemonListVM = hiltViewModel()
) {
    val pokemonListState = viewModel.pokemonListState
    val pokemonGridState = viewModel.pokemonGridState
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SelectTypeLazyRow()
        PokemonVerticalGrid(
            modifier = Modifier,
            pokemonList = pokemonListState.pokemonList,
            pokemonGridState = pokemonGridState
        )
    }
}

