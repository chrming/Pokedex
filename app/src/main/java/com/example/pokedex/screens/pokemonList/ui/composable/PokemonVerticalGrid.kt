package com.example.pokedex.screens.pokemonList.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.pokedex.datasource.local.model.Pokemon
import kotlin.math.absoluteValue

@Composable
fun PokemonVerticalGrid(
    modifier: Modifier = Modifier,
    pokemonList: List<Pokemon>,
    pokemonGridState: LazyGridState,
    onItemClick: (Pokemon) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(3),
        state = pokemonGridState
    ) {
        items(items = pokemonList, key = { it.id }) { pokemon ->
            PokemonListItem(
                modifier = Modifier
                    .graphicsLayer {
                        alpha =
                            2F - pokemonGridState.layoutInfo.normalizedItemPosition(pokemon.id).absoluteValue
                        scaleX =
                            1 - pokemonGridState.layoutInfo.normalizedItemPosition(pokemon.id).absoluteValue / 7F
                        scaleY =
                            1 - pokemonGridState.layoutInfo.normalizedItemPosition(pokemon.id).absoluteValue / 7F
                    }
                    .padding(2.dp),
                spriteUrl = pokemon.sprites.other.officialArtwork.front_default,
                name = pokemon.name,
                type = pokemon.types[0].type,
                onClick = { onItemClick(pokemon) }
            )
            LaunchedEffect(key1 = pokemonGridState.firstVisibleItemIndex) {
                pokemonGridState.animateScrollToItem(
                    pokemonGridState.firstVisibleItemIndex,
                    pokemonGridState.layoutInfo.visibleItemsInfo.firstOrNull()!!.size.height / 2
                )
            }
        }
    }
}

fun LazyGridLayoutInfo.normalizedItemPosition(key: Any): Float =
    visibleItemsInfo
        .firstOrNull { it.key == key }
        ?.let {
            val center = (viewportEndOffset + viewportStartOffset - it.size.height) / 2F
            (it.offset.y.toFloat() - center) / center
        } ?: 0F
