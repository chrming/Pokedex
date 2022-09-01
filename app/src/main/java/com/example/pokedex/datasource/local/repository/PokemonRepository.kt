package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.local.db.dao.PokemonDao
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.model.PokemonUiItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val dao: PokemonDao) : IPokemonRepository {
    override suspend fun getPokemon(idOrName: String): Pokemon {
        return dao.getPokemon(idOrName)
    }
}