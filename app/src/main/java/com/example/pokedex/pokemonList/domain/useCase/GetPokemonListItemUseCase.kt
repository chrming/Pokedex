package com.example.pokedex.pokemonList.domain.useCase

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.network.repository.IApiPokemonRepository
import java.io.IOException

class GetPokemonListItemUseCase(private val apiRepo: IApiPokemonRepository, private val localRepo: IPokemonRepository) {
    @Throws(IOException::class)
    suspend operator fun invoke(idOrName: String): Pokemon {
        localRepo.getPokemonListItem(idOrName)?.let {
            return it
        }
        apiRepo.getPokemonListItem(idOrName).body()?.let {
            return it
        }
        throw IOException("Pokemon is null")
    }
}