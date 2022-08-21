package com.example.pokedex.screens.pokemonList.domain.useCase

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.repository.IPokemonRepository
import javax.inject.Inject

class DeletePokemonUseCase @Inject constructor(private val repository: IPokemonRepository) {
    suspend operator fun invoke(pokemon: Pokemon) {
        repository.deletePokemon(pokemon)
    }
}