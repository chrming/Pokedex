package com.example.pokedex.pokemonList.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.pokemonList.util.pokemonTypes.PokemonTypeList

@Composable
fun SelectTypeLazyRow() {
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

}