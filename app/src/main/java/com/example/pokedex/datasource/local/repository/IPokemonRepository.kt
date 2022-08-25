package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.local.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface IPokemonRepository {
    fun getPokemonList(): Flow<List<Pokemon>>
    fun getPokemonListPage(pageNumber: Int, pageSize: Int): List<Pokemon>
    fun isDatabaseEmpty(): List<Pokemon>
    suspend fun getPokemon(idOrName: String): Pokemon
    suspend fun insertPokemon(pokemon: Pokemon)
    suspend fun deletePokemon(pokemon: Pokemon)
}