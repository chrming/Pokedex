package com.example.pokedex.datasource.network.api

import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.network.model.PokemonListResponse
import retrofit2.Response

interface IPokemonApi {

    suspend fun getAllPokemons(offset: Int, pageSize: Int): PokemonListResponse

    suspend fun getPokemonForUI(idOrName: String): Response<Pokemon>

    suspend fun getPokemon(idOrName: String): Response<Pokemon>
}