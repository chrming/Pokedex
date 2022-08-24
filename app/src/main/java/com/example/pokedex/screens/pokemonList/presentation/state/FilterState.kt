package com.example.pokedex.screens.pokemonList.presentation.state

import com.example.pokedex.screens.pokemonList.ui.composable.filterSection.FilterExpanded
import com.example.pokedex.screens.pokemonList.ui.composable.filterSection.FilterNames

data class FilterState(
    val filterExpanded: FilterExpanded = FilterExpanded(),
    val filterNames: FilterNames = FilterNames(),
    val isFilterSectionExpanded: Boolean = false
)
