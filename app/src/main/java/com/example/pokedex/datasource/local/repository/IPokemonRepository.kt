package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.local.model.Pokemon

interface IPokemonRepository {
    suspend fun getPokemonList(): List<Pokemon>
    suspend fun getPokemon(idOrName: String): Pokemon
    suspend fun insertPokemon(pokemon: Pokemon)
    suspend fun deletePokemon(pokemon: Pokemon)
}