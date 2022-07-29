package com.example.pokedex.network

import com.example.pokedex.network.model.pokemon.Pokemon
import com.example.pokedex.network.model.pokemon.PokemonSimplified
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("pokemon/")
    suspend fun getPokemonList(): List<PokemonSimplified>

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Pokemon

    //@GET("pokemon-form")
}