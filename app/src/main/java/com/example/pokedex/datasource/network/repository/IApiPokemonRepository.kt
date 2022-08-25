package com.example.pokedex.datasource.network.repository

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse
import retrofit2.Response

interface IApiPokemonRepository {

    suspend fun getPokemonList(): Response<PokemonListResponse>

    suspend fun getPokemonListPage(pageNumber: Int, pageSize: Int): Response<PokemonListResponse>

    suspend fun getPokemon(idOrName: String): Response<Pokemon>

    suspend fun getPokemonById(id: Int): Response<Pokemon>
}