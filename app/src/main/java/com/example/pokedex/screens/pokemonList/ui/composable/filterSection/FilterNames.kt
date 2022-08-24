package com.example.pokedex.screens.pokemonList.ui.composable.filterSection

import com.example.pokedex.screens.pokemonList.presentation.pokemonFilters.Filter

data class FilterNames(
    val type: String = Filter.Type.filters[0],
    val version: String = Filter.Version.filters[0],
    val name: String = ""
)
