package com.example.pokedex.datasource

import com.example.pokedex.network.PokemonApi
import com.example.pokedex.network.model.pokemon.Pokemon
import com.example.pokedex.network.model.pokemon.PokemonSimplified
import javax.inject.Inject

class PokemonRepository @Inject constructor (private val api: PokemonApi): IPokemonRepository {
    override suspend fun getPokemonList(): List<PokemonSimplified> {
        return api.getPokemonList()
    }

    override suspend fun getPokemon(id: Int): Pokemon {
        return api.getPokemon(id)
    }
}
