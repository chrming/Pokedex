package com.example.pokedex.datasource.network

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/?offset=0&limit=100/")
    suspend fun getPokemonResponse(): Response<PokemonListResponse>

    @GET("pokemon/{idOrName}")
    suspend fun getPokemon(@Path("idOrName") idOrName: String): Response<Pokemon>

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Response<Pokemon>
    //@GET("pokemon-form")
}