package com.example.pokedex.pokemonList.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.datasource.local.model.Pokemon

@Composable
fun PokemonVerticalGrid(modifier: Modifier = Modifier, pokemonList: List<Pokemon>, pokemonGridState: LazyGridState) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(3),
        state = pokemonGridState
    ) {
        items(items = pokemonList, key = {it.id}) { pokemon ->
            PokemonListItem(
                modifier = Modifier
                    .padding(4.dp),
                spriteUrl = pokemon.sprites.other.officialArtwork.front_default,
                name = pokemon.name,
                type = pokemon.types[0].type
            )
        }
    }
}