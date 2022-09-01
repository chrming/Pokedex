package com.example.pokedex.screens.pokemonList.presentation.composable.filterSection

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.screens.pokemonList.presentation.event.PokemonListEvent
import com.example.pokedex.screens.pokemonList.presentation.state.filter.Filter
import com.example.pokedex.screens.pokemonList.presentation.state.FilterState

@Composable
fun FiltersSection(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        OutlinedTextField(
            modifier = Modifier,
            value = "TODO",
            onValueChange = {},
            label = { Text("Name") })
    }
}