package com.example.pokedex.pokemonList.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedex.datasource.local.model.Pokemon

@Composable
fun PokemonVerticalGrid(modifier: Modifier = Modifier, pokemonList: List<Pokemon>) {
    // filter by type with horizontal lazy list
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        item {
            AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/24.png")
                .build(),
            contentDescription = null
        )  }

        items(items = pokemonList) { pokemon ->
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