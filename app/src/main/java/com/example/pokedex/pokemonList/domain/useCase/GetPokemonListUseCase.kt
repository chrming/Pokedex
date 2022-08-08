package com.example.pokedex.pokemonList.domain.useCase

import android.util.Log
import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.network.repository.IApiPokemonRepository
import com.example.pokedex.pokemonList.util.const.BASE_URL_LENGTH

class GetPokemonListUseCase(
    private val apiRepo: IApiPokemonRepository,
    private val localRepo: IPokemonRepository
) {
    suspend operator fun invoke(): List<Pokemon> {
        val pokemonList = localRepo.getPokemonList()
        if (pokemonList.isEmpty()) {
            Log.d("chm", "api is called")
            apiRepo.getPokemonList().body()?.let {
                for (pokemonLink in it.results) {
                    apiRepo.getPokemonById(getIdFromUrl(pokemonLink.url)).body()
                        ?.let { pokemon ->
                            localRepo.insertPokemon(pokemon)
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
//TODO use kotlin flow to have instant return