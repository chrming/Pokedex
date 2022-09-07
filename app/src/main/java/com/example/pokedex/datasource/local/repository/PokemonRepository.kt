package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.local.db.dao.PokemonDao
import com.example.pokedex.datasource.model.Pokemon
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val dao: PokemonDao) : IPokemonRepository {
    override suspend fun getPokemon(name: String): Pokemon {
        return dao.getPokemon(name)
    }
}