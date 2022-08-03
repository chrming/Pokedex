package com.example.pokedex.pokemonList.domain.state

import com.example.pokedex.datasource.network.model.pokemon.Pokemon

data class PokemonListState(
    val pokemonList: List<Pokemon> = emptyList()
)