package com.example.pokedex.screens.pokemonList.ui.composable.filter

import com.example.pokedex.screens.pokemonList.util.pokemonFilters.Filter

data class FilterNames(
    val type: String = Filter.Type.filters[0],
    val version: String = Filter.Version.filters[0]
)
