package com.example.pokedex.datasource

import com.example.pokedex.network.PokemonApi
import com.example.pokedex.network.model.pokemon.Pokemon
import com.example.pokedex.network.model.pokemon.PokemonListResponse
import retrofit2.Response
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val api: PokemonApi) : IPokemonRepository {
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
