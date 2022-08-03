package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.local.PokemonDao
import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.model.PokemonForUi
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val dao: PokemonDao): IPokemonRepository{
    override suspend fun getPokemonList(): PokemonListResponse {
        return dao.getPokemonList()
    }

    override suspend fun getPokemonListItem(url: String): Pokemon {
        return dao.getPokemonListItem(url = url)
    }

    override suspend fun getPokemon(id: Int): PokemonForUi {
        return dao.getPokemon(id)
    }
}