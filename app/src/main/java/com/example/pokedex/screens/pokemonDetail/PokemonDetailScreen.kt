package com.example.pokedex.screens.pokemonDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.pokedex.navigation.PokemonDetailScreenNavArgs
import com.example.pokedex.screens.home.domain.HomeVM
import com.ramcosta.composedestinations.annotation.Destination

@Destination(navArgsDelegate = PokemonDetailScreenNavArgs::class)
@Composable
fun PokemonDetailScreen(
    viewModel: HomeVM = hiltViewModel(),
) {
    val pokemonState = viewModel.pokemonState.value.pokemon
    Column() {
        AsyncImage(
            model = pokemonState.sprites.other.officialArtwork?.front_default,
            contentDescription = null
        )
        Text(text = pokemonState.name)

    }

}