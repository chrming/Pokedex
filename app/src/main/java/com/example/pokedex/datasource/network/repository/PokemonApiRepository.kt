package com.example.pokedex.datasource.network.repository

import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.network.IPokemonApi
import retrofit2.Response
import javax.inject.Inject

class PokemonApiRepository @Inject constructor(private val api: IPokemonApi) :
    IPokemonApiRepository {
    override suspend fun getAllPokemons(offset: Int, pageSize: Int): List<Pokemon> {
        val pokemonList = mutableListOf<Pokemon>()
        api.getAllPokemons(offset, pageSize).results.onEach { responseListItem ->
            api.getPokemon(responseListItem.name).body()
                ?.let { pokemon -> pokemonList.add(pokemon) }
        }
        return pokemonList
    }

    override suspend fun getPokemon(idOrName: String): Response<Pokemon> {
        return api.getPokemon(idOrName)
    }

    override suspend fun getPokemonForUI(idOrName: String): Response<Pokemon> {
        TODO("Not yet implemented")
    }
}