package com.example.pokedex.datasource.network.repository

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse
import retrofit2.Response

interface IApiPokemonRepository {
    // Return a response from api converting json into PokemonListResponse
    // object.
    suspend fun getPokemonList(): Response<PokemonListResponse>

    // Return a Pokemon object after given url
    suspend fun getPokemonListItem(url: String): Response<Pokemon>

    // Return a Pokemon object after given id
    suspend fun getPokemon(id: Int): Response<Pokemon>
}