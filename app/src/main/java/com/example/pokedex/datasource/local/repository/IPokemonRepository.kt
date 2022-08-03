package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.model.PokemonForUi
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse

interface IPokemonRepository {
    suspend fun getPokemonList(): PokemonListResponse
    suspend fun getPokemonListItem(url: String): Pokemon
    suspend fun getPokemon(id: Int): PokemonForUi
    suspend fun insertPokemon(pokemon: Pokemon): Unit
    suspend fun deletePokemon(pokemon: Pokemon):Unit
}