package com.example.pokedex.screens.pokemonList.domain.useCase

import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.network.repository.IApiPokemonRepository
import com.example.pokedex.screens.pokemonList.util.const.BASE_URL_LENGTH
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GetPokemonListUseCase(
    private val apiRepo: IApiPokemonRepository,
    private val localRepo: IPokemonRepository
) {
    operator fun invoke(): Flow<List<Pokemon>> {
        CoroutineScope(Dispatchers.IO).launch {
            if (localRepo.isDatabaseEmpty().isEmpty()) {
                apiRepo.getPokemonList().body()?.let {
                    for (pokemonLink in it.results) {
                        apiRepo.getPokemonById(getIdFromUrl(pokemonLink.url)).body()
                            ?.let { pokemon ->
                                localRepo.insertPokemon(pokemon)
                            }
                    }
                }
            }
        }
        return localRepo.getPokemonList()
    }

    private fun getIdFromUrl(url: String): Int {
        return url.drop(BASE_URL_LENGTH).dropLast(1).toInt()
    }
}