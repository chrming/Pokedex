package com.example.pokedex.screens.pokemonList.domain.state

import com.example.pokedex.datasource.local.model.Pokemon

data class PokemonListState(
    val pokemonList: List<Pokemon> = emptyList()
)