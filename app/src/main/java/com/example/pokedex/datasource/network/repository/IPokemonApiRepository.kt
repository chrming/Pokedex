package com.example.pokedex.datasource.network.repository

import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.network.model.PokemonListResponse
import retrofit2.Response

interface IPokemonApiRepository {

    suspend fun getAllPokemons(offset: Int, pageSize: Int): List<Pokemon>

    suspend fun getPokemon(idOrName: String): Response<Pokemon>

    suspend fun getPokemonForUI(idOrName: String): Response<Pokemon>

}