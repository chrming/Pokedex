package com.example.pokedex.pokemonList.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.network.model.pokemon.Pokemon

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonVerticalGrid(modifier: Modifier = Modifier, pokemonList: List<Pokemon>) {
    LazyVerticalGrid(
        modifier = modifier,
        cells = GridCells.Fixed(3)
    ) {
        items(items = pokemonList) { pokemon ->
            PokemonListItem(
                modifier = Modifier
                    .padding(4.dp)
                , pokemon = pokemon
            )
        }
    }
}