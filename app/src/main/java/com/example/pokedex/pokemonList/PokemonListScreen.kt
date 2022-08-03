package com.example.pokedex.pokemonList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.pokemonList.domain.PokemonListVM
import com.example.pokedex.pokemonList.ui.composable.PokemonVerticalGrid

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonListScreen(
    viewModel: PokemonListVM = hiltViewModel()
) {
    val pokemonListState = viewModel.pokemonListState
    PokemonVerticalGrid(
        modifier = Modifier
            .fillMaxSize(),
        pokemonList = pokemonListState.pokemonList
    )
}