package com.example.pokedex.screens.pokemonList.presentation.state.filter

data class FilterNames(
    val type: String = Filter.Type.filters[0],
    val version: String = Filter.Version.filters[0],
    val name: String = ""
)
