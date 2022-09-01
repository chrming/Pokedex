package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.model.PokemonUiItem
import kotlinx.coroutines.flow.Flow

interface IPokemonRepository {
    suspend fun getPokemon(idOrName: String): Pokemon

}