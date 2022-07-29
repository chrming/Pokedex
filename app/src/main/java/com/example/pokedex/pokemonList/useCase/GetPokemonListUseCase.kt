package com.example.pokedex.pokemonList.useCase

import com.example.pokedex.datasource.IPokemonRepository
import com.example.pokedex.network.model.pokemon.PokemonListResponse
import java.io.IOException

class GetPokemonListUseCase(private val repo: IPokemonRepository) {
    @Throws(IOException::class)
    suspend operator fun invoke(): PokemonListResponse {
        repo.getPokemonList().body()?.let {
            return it
            //throw IOException("Pokemon List Response is null")
        }
        throw IOException("Pokemon List Response is null")
    }
}