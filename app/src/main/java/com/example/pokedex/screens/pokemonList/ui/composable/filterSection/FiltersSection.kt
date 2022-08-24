package com.example.pokedex.screens.pokemonList.ui.composable.filterSection

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.screens.pokemonList.presentation.event.PokemonListEvent
import com.example.pokedex.screens.pokemonList.presentation.pokemonFilters.Filter
import com.example.pokedex.screens.pokemonList.presentation.state.FilterState
import com.example.pokedex.screens.pokemonList.ui.composable.backgroundColorByType

@Composable
fun FiltersSection(
    modifier: Modifier = Modifier,
    filterState: FilterState,
    onEvent: (PokemonListEvent) -> Unit
) {
    Column(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.width(IntrinsicSize.Min),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = filterState.filterNames.name,
                onValueChange = { onEvent(PokemonListEvent.FilterEvent.Name.OnChange(it)) },
                label = { Text(text = "Name") })
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = { onEvent(PokemonListEvent.FilterEvent.Type.FilterExpanded(true)) },
                    colors = ButtonDefaults.buttonColors()
                ) {
                    Text(text = "Type: ${filterState.filterNames.type}")
                }
                if (filterState.filterExpanded.typeIsExpanded) {
                    FilterAlertDialog(
                        title = "Pokemon Type",
                        filtersNames = Filter.Type.filters,
                        onItemClick = {
                            onEvent(PokemonListEvent.FilterEvent.Type.FilterSelected(it))
                            onEvent(PokemonListEvent.FilterEvent.Type.FilterExpanded(false))
                        },
                        onDismiss = { onEvent(PokemonListEvent.FilterEvent.Type.FilterExpanded(false)) },
                        itemColors = {
                            ButtonDefaults.buttonColors(backgroundColor = backgroundColorByType(it))
                        })
                }
                TextButton(
                    onClick = { onEvent(PokemonListEvent.FilterEvent.Version.FilterExpanded(true)) },
                    colors = ButtonDefaults.buttonColors()
                ) {
                    Text(text = "Version: ${filterState.filterNames.version}")
                }
                if (filterState.filterExpanded.versionIsExpanded) {
                    FilterAlertDialog(
                        title = "Pokemon Version",
                        filtersNames = Filter.Version.filters,
                        onItemClick = {
                            onEvent(PokemonListEvent.FilterEvent.Version.FilterSelected(it))
                            onEvent(PokemonListEvent.FilterEvent.Version.FilterExpanded(false))
                        },
                        onDismiss = {
                            onEvent(
                                PokemonListEvent.FilterEvent.Version.FilterExpanded(
                                    false
                                )
                            )
                        },
                        itemColors = { ButtonDefaults.buttonColors(backgroundColor = Color.Gray) }
                    )
                }
            }
        }
    }
}