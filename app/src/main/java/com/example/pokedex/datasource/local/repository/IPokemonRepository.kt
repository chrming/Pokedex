package com.example.pokedex.datasource.local.repository

import com.example.pokedex.datasource.model.Pokemon

interface IPokemonRepository {
    suspend fun getPokemon(idOrName: String): Pokemon

}