package com.example.pokedex.screens.pokemonList.presentation.state

import com.example.pokedex.screens.pokemonList.ui.composable.filter.FilterExpanded
import com.example.pokedex.screens.pokemonList.ui.composable.filter.FilterNames

data class FilterState(
    val filterExpanded: FilterExpanded = FilterExpanded(),
    val filterNames: FilterNames = FilterNames()

)
