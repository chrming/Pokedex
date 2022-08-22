package com.example.pokedex.screens.pokemonList.domain.state

import com.example.pokedex.screens.pokemonList.ui.composable.filter.FilterExpanded
import com.example.pokedex.screens.pokemonList.ui.composable.filter.FilterNames
import com.example.pokedex.screens.pokemonList.util.pokemonFilters.Filter

data class FilterState(
    val filterExpanded: FilterExpanded = FilterExpanded(),
    val filterNames: FilterNames = FilterNames()

)
