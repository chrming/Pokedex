package com.example.pokedex.network

import retrofit2.Retrofit

object PokemonService {
    const val BASE_URL = "https://pokeapi.co/api/v2/"

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()

    val api: PokemonApi = getRetrofit().create(PokemonApi::class.java)
}