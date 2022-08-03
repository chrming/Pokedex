package com.example.pokedex.pokemonList.domain.useCase

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.network.repository.IApiPokemonRepository
import com.example.pokedex.pokemonList.util.const.BASE_URL_LENGTH
import java.io.IOException

class GetPokemonListUseCase(
    private val apiRepo: IApiPokemonRepository,
    private val localRepo: IPokemonRepository
) {
    @Throws(IOException::class)
    suspend operator fun invoke(): List<Pokemon> {
        localRepo.getPokemonList()?.let {
            return it
        }
        apiRepo.getPokemonList().body()?.let {
            val pokemonList = mutableListOf<Pokemon>()
            for (pokemonLink in it.results) {
                apiRepo.getPokemon(pokemonLink.url.drop(BASE_URL_LENGTH)).body()
                    ?.let { pokemon -> pokemonList.add(pokemon) }
            }
            return pokemonList
        }
        throw IOException("Pokemon List Response is null")
    }
}