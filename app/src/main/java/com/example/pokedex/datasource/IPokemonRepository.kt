package com.example.pokedex.datasource

import com.example.pokedex.network.model.pokemon.Pokemon
import com.example.pokedex.network.model.pokemon.PokemonSimplified

interface IPokemonRepository {
    suspend fun getPokemonList(): List<PokemonSimplified>

    suspend fun getPokemon(id: Int): Pokemon
}