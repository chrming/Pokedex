package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.model.PokemonForUi
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse

interface IPokemonRepository {
    suspend fun getPokemonList(): List<Pokemon>
    suspend fun getPokemon(idOrName: String): Pokemon
    suspend fun insertPokemon(pokemon: Pokemon)
    suspend fun deletePokemon(pokemon: Pokemon)
}