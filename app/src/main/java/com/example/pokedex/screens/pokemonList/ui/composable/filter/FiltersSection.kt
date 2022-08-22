package com.example.pokedex.screens.pokemonList.ui.composable.filter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokedex.screens.pokemonList.domain.PokemonListEvent
import com.example.pokedex.screens.pokemonList.domain.state.FilterState
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
            TextButton(onClick = { onEvent(PokemonListEvent.FilterEvent.FilterExpanded(Filter.Type)) }) {
                Text(text = "Type: ${filterState.filterNames.type}")

            }
            if (filterState.filterExpanded.typeIsExpanded) {
                FilterAlertDialog(title = "Pokemon Type", onEvent = onEvent, filter = Filter.Type)
            }

            TextButton(onClick = { onEvent(PokemonListEvent.FilterEvent.FilterExpanded(Filter.Version)) }) {
                Text(text = "Version: ${filterState.filterNames.version}")

            }
            if (filterState.filterExpanded.versionIsExpanded) {
                FilterAlertDialog(
                    title = "Pokemon Version",
                    columns = 2,
                    rows = 10,
                    onEvent = onEvent,
                    filter = Filter.Version
                )
            }
        }
    }
}