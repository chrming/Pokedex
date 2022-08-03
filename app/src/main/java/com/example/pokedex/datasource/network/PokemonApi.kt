package com.example.pokedex.datasource.network

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/?offset=0&limit=100/")
    suspend fun getPokemonList(): Response<PokemonListResponse>

    @GET("pokemon/{url}")
    suspend fun getPokemonListItem(@Path("url") url: String): Response<Pokemon>

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Response<Pokemon>

    //@GET("pokemon-form")
}