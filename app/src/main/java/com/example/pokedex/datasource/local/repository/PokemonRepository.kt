package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.local.db.PokemonDao
import com.example.pokedex.datasource.local.model.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val dao: PokemonDao) : IPokemonRepository {
    override suspend fun getPokemon(idOrName: String): Pokemon {
        return dao.getPokemon(idOrName)
    }

    override fun getPokemonList(): Flow<List<Pokemon>> {
        return dao.getPokemonList()
    }

    override fun isDatabaseEmpty(): List<Pokemon> {
        return dao.isDatabaseEmpty()
    }

    override suspend fun insertPokemon(pokemon: Pokemon) {
        dao.insertPokemon(pokemon)
    }

    override suspend fun deletePokemon(pokemon: Pokemon) {
        dao.deletePokemon(pokemon)
    }
}