package com.example.pokedex.screens.pokemonList.presentation.state

import com.example.pokedex.screens.pokemonList.presentation.state.filter.FilterExpanded
import com.example.pokedex.screens.pokemonList.presentation.state.filter.FilterNames

data class FilterState(
    val filterExpanded: FilterExpanded = FilterExpanded(),
    val filterNames: FilterNames = FilterNames(),
    val isFilterSectionExpanded: Boolean = false
)
