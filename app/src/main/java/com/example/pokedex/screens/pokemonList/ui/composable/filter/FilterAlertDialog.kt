package com.example.pokedex.screens.pokemonList.ui.composable.filter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokedex.screens.pokemonList.domain.PokemonListEvent
import com.example.pokedex.screens.pokemonList.ui.composable.backgroundColorByType
import com.example.pokedex.screens.pokemonList.util.pokemonFilters.Filter
import java.util.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun <T : Filter> FilterAlertDialog(
    modifier: Modifier = Modifier,
    title: String,
    rows: Int = 5,
    columns: Int = 4,
    filter: T,
    onEvent: (PokemonListEvent) -> Unit
) {
    AlertDialog(
        modifier = modifier,
        title = { Text(text = title) },
        onDismissRequest = { onEvent(PokemonListEvent.FilterEvent.FilterExpanded(filterType = filter)) },
        text = {
            Column() {
                for (row in 1..rows) {
                    Row() {
                        for (column in 1..columns) {
                            val index = columns * (row - 1) + column - 1
                            Chip(
                                onClick = {
                                    onEvent(
                                        PokemonListEvent.FilterEvent.FilterBy(
                                            filter = filter,
                                            filterName = filter.filters[index]
                                        )
                                    )
                                    onEvent(PokemonListEvent.FilterEvent.FilterExpanded(filterType = filter))
                                },
                                colors = ChipDefaults.chipColors(
                                    backgroundColor = backgroundColorByType(
                                        filter.filters[index]
                                    )
                                )
                            ) {
                                Text(text =
                                filter.filters[index].replace("-", " ").split(" ")
                                    .joinToString(separator = " ") { filterName ->
                                        filterName.replaceFirstChar {
                                            if (it.isLowerCase()) it.titlecase(
                                                Locale.getDefault()
                                            ) else it.toString()
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {

        },
        dismissButton = {

        }
    )
}