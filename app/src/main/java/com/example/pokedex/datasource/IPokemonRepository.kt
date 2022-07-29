package com.example.pokedex.datasource

import com.example.pokedex.network.model.pokemon.Pokemon
import com.example.pokedex.network.model.pokemon.PokemonListResponse
import com.example.pokedex.network.model.pokemon.ResponseListItem
import retrofit2.Response

interface IPokemonRepository {
    suspend fun getPokemonList(): Response<PokemonListResponse>
    suspend fun getPokemonListItem(url: String): Response<Pokemon>
    suspend fun getPokemon(id: Int): Response<Pokemon>
}