package com.example.pokedex.pokemonList.domain.useCase

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.repository.IPokemonRepository

class InsertPokemonUseCase(private val localRepo: IPokemonRepository) {
    suspend operator fun invoke(pokemon: Pokemon) {
        localRepo.insertPokemon(pokemon)
    }
}