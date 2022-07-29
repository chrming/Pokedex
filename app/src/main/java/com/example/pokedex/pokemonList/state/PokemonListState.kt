package com.example.pokedex.pokemonList.state

import com.example.pokedex.network.model.pokemon.Pokemon

data class PokemonListState(
    val pokemonList: List<Pokemon> = emptyList()
)