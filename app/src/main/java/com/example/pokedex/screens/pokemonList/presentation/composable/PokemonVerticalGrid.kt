package com.example.pokedex.screens.pokemonList.presentation.composable

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.pokedex.datasource.model.Pokemon

@Composable
fun PokemonVerticalGrid(
    modifier: Modifier = Modifier,
    pokemonList: LazyPagingItems<Pokemon>,
    pokemonGridState: LazyGridState,
    onItemClick: (Pokemon) -> Unit
) {

    LazyColumn(
        modifier = modifier,
    ) {
        items(items = pokemonList, key = { it.id }) { pokemon ->
            pokemon?.let {
                PokemonListItem(
                    modifier = Modifier
                        .padding(2.dp),
                    spriteUrl = pokemon.sprites.other.officialArtwork.front_default,
                    name = pokemon.name,
                    type = pokemon.types[0].type,
                    onClick = { onItemClick(pokemon) }
                )
            }
        }
        /*
        LaunchedEffect(key1 = pokemonGridState.firstVisibleItemIndex) {
            pokemonGridState.animateScrollToItem(
                pokemonGridState.firstVisibleItemIndex,
                pokemonGridState.layoutInfo.visibleItemsInfo.firstOrNull()!!.size.height / 2
            )
        }
         */
    }
}

fun LazyGridLayoutInfo.normalizedItemPosition(key: Any): Float =
    visibleItemsInfo
        .firstOrNull { it.key == key }
        ?.let {
            val center = (viewportEndOffset + viewportStartOffset - it.size.height) / 2F
            (it.offset.y.toFloat() - center) / center
        } ?: 0F
