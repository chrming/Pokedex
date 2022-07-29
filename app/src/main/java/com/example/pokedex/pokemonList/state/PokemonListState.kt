package com.example.pokedex.pokemonList.state

import com.example.pokedex.network.model.pokemon.Pokemon
import com.example.pokedex.network.model.pokemon.PokemonSimplified

data class PokemonListState(
    val pokemonList: List<PokemonSimplified> = emptyList()
)