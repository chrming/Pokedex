package com.example.pokedex.screens.pokemonDetail.domain.useCase

import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.network.repository.IPokemonApiRepository
import java.io.IOException

class GetPokemonByNameUseCase(
    private val apiRepo: IPokemonApiRepository,
    private val localRepo: IPokemonRepository
) {
    @Throws(IOException::class)
    suspend operator fun invoke(name: String): Pokemon {
        localRepo.getPokemon(name)?.let {
            return it
        }
        apiRepo.getPokemon(name).body()?.let {
            return it
        }
        throw IOException("Pokemon is null")
    }
}