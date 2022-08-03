package com.example.pokedex.datasource.network.repository

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.network.PokemonApi
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse
import retrofit2.Response
import javax.inject.Inject

class ApiPokemonRepository @Inject constructor(private val api: PokemonApi) : IApiPokemonRepository {
    override suspend fun getPokemonList(): Response<PokemonListResponse> {
        return api.getPokemonResponse()
    }


    override suspend fun getPokemon(idOrName: String): Response<Pokemon> {
        return api.getPokemon(idOrName)
    }
}
