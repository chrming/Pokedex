package com.example.pokedex.screens.pokemonList.ui.composable.filter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokedex.screens.pokemonList.presentation.event.PokemonListEvent
import com.example.pokedex.screens.pokemonList.presentation.state.FilterState
import com.example.pokedex.screens.pokemonList.util.pokemonFilters.Filter

@Composable
fun FiltersSection(
    modifier: Modifier = Modifier,
    filterState: FilterState,
    onEvent: (PokemonListEvent) -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        //  name, location_area_encounter

        Row(modifier = Modifier.fillMaxWidth()) {

            TextButton(onClick = { onEvent(PokemonListEvent.FilterEvent.Type.FilterExpanded(true)) }) {
                Text(text = "Type: ${filterState.filterNames.type}")
            }
            if (filterState.filterExpanded.typeIsExpanded) {

                FilterAlertDialog(
                    title = "Pokemon Type",
                    columns = 4,
                    rows = 5,
                    filtersNames = Filter.Type.filters,
                    onItemClick = {
                        onEvent(PokemonListEvent.FilterEvent.Type.FilterSelected(it))
                        onEvent(PokemonListEvent.FilterEvent.Type.FilterExpanded(false))
                    },
                    onDismiss = { onEvent(PokemonListEvent.FilterEvent.Type.FilterExpanded(false)) }
                )
            }

            TextButton(onClick = { onEvent(PokemonListEvent.FilterEvent.Version.FilterExpanded(true)) }) {
                Text(text = "Version: ${filterState.filterNames.version}")
            }
            if (filterState.filterExpanded.versionIsExpanded) {

                FilterAlertDialog(
                    title = "Pokemon Version",
                    columns = 2,
                    rows = 10,
                    filtersNames = Filter.Version.filters,
                    onItemClick = {
                        onEvent(PokemonListEvent.FilterEvent.Version.FilterSelected(it))
                        onEvent(PokemonListEvent.FilterEvent.Version.FilterExpanded(false))
                    },
                    onDismiss = { onEvent(PokemonListEvent.FilterEvent.Version.FilterExpanded(false)) }
                )
            }
        }
    }
}