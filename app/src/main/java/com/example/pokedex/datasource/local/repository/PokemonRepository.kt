package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.local.db.PokemonDao
import com.example.pokedex.datasource.local.model.Pokemon
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val dao: PokemonDao): IPokemonRepository{
    override suspend fun getPokemonList(): List<Pokemon> {
        return dao.getPokemonList()
    }

    override suspend fun getPokemon(idOrName: String): Pokemon {
        return dao.getPokemon(idOrName)
    }

    override suspend fun insertPokemon(pokemon: Pokemon) {
        dao.insertPokemon(pokemon)
    }

    override suspend fun deletePokemon(pokemon: Pokemon) {
        dao.deletePokemon(pokemon)
    }
}