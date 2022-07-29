package com.example.pokedex.pokemonList.useCase

import com.example.pokedex.datasource.IPokemonRepository
import com.example.pokedex.network.model.pokemon.Pokemon
import java.io.IOException

class GetPokemonListItemUseCase(private val repo: IPokemonRepository) {
    @Throws(IOException::class)
    suspend operator fun invoke(url: String): Pokemon {
        repo.getPokemonListItem(url).body()?.let {
            return it
        }
        throw IOException("Pokemon is null")
    }
}