package com.example.pokedex.datasource.network.api

import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.network.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.*

interface PokemonApi : IPokemonApi {

    @GET("pokemon/")
    override suspend fun getAllPokemons(
        @Query("offset") offset: Int,
        @Query("limit") pageSize: Int
    ): PokemonListResponse

    @GET("pokemon")
    override suspend fun getPokemonForUI(@Query("idOrName") idOrName: String): Response<Pokemon>

    @GET("pokemon/{idOrName}")
    override suspend fun getPokemon(@Path("idOrName") idOrName: String): Response<Pokemon>
}