package com.example.pokedex.screens.pokemonList.domain.pager

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.network.repository.IApiPokemonRepository
import com.example.pokedex.screens.pokemonList.domain.useCase.getIdFromUrl
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class PokemonListRemoteMediator(
    val localRepo: IPokemonRepository,
    val apiRepo: IApiPokemonRepository
) : RemoteMediator<Int, Pokemon>(){

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Pokemon>
    ): MediatorResult {
        try {
            val pageNumber = state.anchorPosition ?: 0
            val response = apiRepo.getPokemonListPage(pageNumber, pageSize = 50)

            val pokemons = mutableListOf<Pokemon>()
            response.body()?.let { result ->
                result.results.forEach {
                    apiRepo.getPokemonById(getIdFromUrl(it.url)).body()
                        ?.let { pokemon ->
                            localRepo.insertPokemon(pokemon)
                        }
                }
            }
            return MediatorResult.Success(true)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        }
    }
}