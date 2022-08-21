package com.example.pokedex.screens.pokemonList.ui.composable

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListLayoutInfo
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokedex.screens.pokemonList.util.pokemonTypes.PokemonTypeList
import kotlin.math.absoluteValue

@Preview
@Composable
fun PreviewSelectTypeLazyRow() {
    SelectTypeLazyRow(onItemClick = {})
}

@Composable
fun SelectTypeLazyRow(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    val listState = rememberLazyListState(5)
    val pokemonTypesListState = PokemonTypeList.toMutableStateList()

    LazyRow(
        modifier = modifier,
        state = listState,
    ) {
        items(pokemonTypesListState, key = { it.type.name }) { pokemon ->
            PokemonListItem(
                modifier = Modifier
                    .graphicsLayer {
                        alpha =
                            1.25F - listState.layoutInfo.normalizedItemPosition(pokemon.type.name).absoluteValue / 2F
                        scaleX =
                            1 - listState.layoutInfo.normalizedItemPosition(pokemon.type.name).absoluteValue / 7F
                        scaleY =
                            1 - listState.layoutInfo.normalizedItemPosition(pokemon.type.name).absoluteValue / 7F
                    }
                    .size(100.dp),
                spriteUrl = pokemon.spriteUrl,
                name = pokemon.type.name,
                type = pokemon.type,
                onClick = {}
            )
            LaunchedEffect(key1 = listState.firstVisibleItemIndex) {
                listState.animateScrollToItem(
                    listState.firstVisibleItemIndex,
                    listState.layoutInfo.visibleItemsInfo.firstOrNull()!!.size / 2
                )
            }
            LaunchedEffect(key1 = pokemonTypesListState) {
                if (listState.firstVisibleItemIndex >= listState.layoutInfo.visibleItemsInfo.size - 5) {
                    val movedElement = pokemonTypesListState.first()
                    pokemonTypesListState.removeFirst()
                    pokemonTypesListState.add(movedElement)
                }
            }
            LaunchedEffect(key1 = pokemonTypesListState) {
                if (listState.firstVisibleItemIndex <= 5) { //TODO condition
                    val movedElement = pokemonTypesListState.last()
                    pokemonTypesListState.removeLast()
                    pokemonTypesListState.add(0, movedElement)
                }
            }
        }
    }
}

fun LazyListLayoutInfo.normalizedItemPosition(key: Any): Float =
    visibleItemsInfo
        .firstOrNull { it.key == key }
        ?.let {
            val center = (viewportEndOffset + viewportStartOffset - it.size) / 2F
            (it.offset.toFloat() - center) / center
        } ?: 0F
