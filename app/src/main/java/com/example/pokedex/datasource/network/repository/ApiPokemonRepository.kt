package com.example.pokedex.datasource.network.repository

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.network.PokemonApi
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse
import retrofit2.Response
import javax.inject.Inject

class ApiPokemonRepository @Inject constructor(private val api: PokemonApi) : IApiPokemonRepository {
    override suspend fun getPokemonList(): Response<PokemonListResponse> {
        return api.getPokemonList()
    }

    override suspend fun getPokemonListItem(url: String): Response<Pokemon> {
        return api.getPokemonListItem(url = url)
    }

    override suspend fun getPokemon(id: Int): Response<Pokemon> {
        return api.getPokemon(id)
    }
}
