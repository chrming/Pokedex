package com.example.pokedex.pokemonList.useCase

import com.example.pokedex.datasource.IPokemonRepository
import com.example.pokedex.network.model.pokemon.Pokemon
import com.example.pokedex.network.model.pokemon.PokemonSimplified

class GetPokemonListUseCase(private val repo: IPokemonRepository) {
    suspend operator fun invoke(): List<PokemonSimplified> {
        return repo.getPokemonList()
    }
}