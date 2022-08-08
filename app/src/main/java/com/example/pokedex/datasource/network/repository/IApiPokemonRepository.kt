package com.example.pokedex.datasource.network.repository

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse
import retrofit2.Response

interface IApiPokemonRepository {

    suspend fun getPokemonList(): Response<PokemonListResponse>

    // Return a Pokemon object after given id
    suspend fun getPokemon(idOrName: String): Response<Pokemon>

    suspend fun getPokemonById(id: Int): Response<Pokemon>
}