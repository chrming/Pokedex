package com.example.pokedex.pokemonList.domain.useCase

import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.network.repository.IApiPokemonRepository
import com.example.pokedex.datasource.network.model.pokemon.PokemonListResponse
import java.io.IOException

class GetPokemonListUseCase(
    private val apiRepo: IApiPokemonRepository,
    private val localRepo: IPokemonRepository
) {
    @Throws(IOException::class)
    suspend operator fun invoke(): PokemonListResponse {
        localRepo.getPokemonList()?.let {
            return it
        }
        apiRepo.getPokemonList().body()?.let {
            return it
            //throw IOException("Pokemon List Response is null")
        }
        throw IOException("Pokemon List Response is null")
    }
}