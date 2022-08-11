package com.example.pokedex.pokemonList.ui.composable

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListLayoutInfo
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokedex.pokemonList.util.pokemonTypes.PokemonTypeList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview
@Composable
fun PreviewSelectTypeLazyRow() {
    SelectTypeLazyRow()
}

@Composable
fun SelectTypeLazyRow(modifier: Modifier = Modifier) {
    val rowState = rememberLazyListState(4)
    val scope = rememberCoroutineScope()
    val listState = PokemonTypeList.toMutableStateList()

    LazyRow(
        modifier = modifier,
        state = rowState,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(listState, key = { it.type.name }) { pokemon ->
            PokemonListItem(
                modifier = Modifier
                    .graphicsLayer {
                        alpha =
                            1.5F - rowState.layoutInfo.normalizedItemPosition(pokemon.type.name)
                    }
                    .size(100.dp)
                    .padding(2.dp),
                spriteUrl = pokemon.spriteUrl,
                name = pokemon.type.name,
                type = pokemon.type,
                state = rowState
            )
            scope.launch {
                rowState.animateScrollToItem(
                    rowState.firstVisibleItemIndex,
                    rowState.layoutInfo.visibleItemsInfo.firstOrNull()!!.size / 2
                )
            }
            LaunchedEffect(key1 = listState){
                Log.d("chm", "${rowState.firstVisibleItemIndex} ${rowState.layoutInfo.totalItemsCount}")
                if (rowState.firstVisibleItemIndex + 6 == rowState.layoutInfo.totalItemsCount) {
                    val moveToLast = listState.first()
                    listState.removeFirst()
                    listState.add(moveToLast)
                }
                if (rowState.firstVisibleItemIndex == 0) {
                    val deletedItem = listState.last()
                    listState.removeLast()
                    listState.asReversed().add(deletedItem)

                }
            }
        }
    }
}

fun LazyListLayoutInfo.normalizedItemPosition(key: Any): Float =
    visibleItemsInfo
        .firstOrNull { it.key == key }?.let {
            val center = (viewportEndOffset + viewportStartOffset - it.size) / 2F
            (it.offset.toFloat() - center) / center
        } ?: 0F