package com.example.pokedex.pokemonList.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.pokemonList.util.PokemonTypeList

@Composable
fun PokemonVerticalGrid(modifier: Modifier = Modifier, pokemonList: List<Pokemon>) {
    // filter by type with horizontal lazy list
    Column(modifier = modifier) {
        LazyRow {
            items(PokemonTypeList) { pokemon ->
                PokemonListItem(
                    modifier = Modifier
                        .padding(4.dp),
                    spriteUrl = pokemon.spriteUrl,
                    name = pokemon.type.name,
                    type = pokemon.type
                )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {
            items(items = pokemonList) { pokemon ->
                PokemonListItem(
                    modifier = Modifier
                        .padding(4.dp),
                    spriteUrl = pokemon.sprites.other.officialArtwork.front_default,
                    name = pokemon.name,
                    type = pokemon.types[1].type
                )
            }
        }
    }
}