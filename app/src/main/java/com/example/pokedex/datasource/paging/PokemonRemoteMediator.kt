package com.example.pokedex.datasource.paging

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.LoadType.*
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.pokedex.const.Constants.ITEM_PER_PAGE
import com.example.pokedex.datasource.local.db.PokemonDatabase
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.model.PokemonRemoteKeys
import com.example.pokedex.datasource.network.repository.IPokemonApiRepository

// TODO on REFRESH remoteKeys is always null
@OptIn(ExperimentalPagingApi::class)
class PokemonRemoteMediator(
    private val pokemonApiRepo: IPokemonApiRepository,
    private val pokemonDatabase: PokemonDatabase
) : RemoteMediator<Int, Pokemon>() {

    private val pokemonDao = pokemonDatabase.pokemonDao()
    private val pokemonRemoteKeyDao = pokemonDatabase.pokemonRemoteKeyDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Pokemon>
    ): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                REFRESH -> {
                    Log.d("chm", "Refreshing")
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    Log.d("chm", "Remote keys: $remoteKeys")
                    remoteKeys?.nextPage?.minus(1) ?: 0
                }
                PREPEND -> {
                    Log.d("chm", "Prepending")
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                APPEND -> {
                    Log.d("chm", "Appending")
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }
            Log.d("chm", "Current Page: $currentPage")

            val response = pokemonApiRepo.getAllPokemons(
                offset = currentPage * ITEM_PER_PAGE,
                pageSize = ITEM_PER_PAGE
            )
            Log.d("chm", "Response from API: ${response.size}")

            val endOfPaginationReached = response.isEmpty()

            val prevPage = if (currentPage == 0) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            Log.d("chm", "Next , Previous : ${nextPage} ${prevPage}")

            pokemonDatabase.withTransaction {
                if (loadType == REFRESH) {
                    pokemonDao.deleteAllPokemon()
                    pokemonRemoteKeyDao.deleteAllRemoteKeys()
                }
                val keys = response.map {
                    PokemonRemoteKeys(
                        id = it.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }

                pokemonRemoteKeyDao.addAllRemoteKeys(keys)
                pokemonDao.addPokemons(response)
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            Log.d("chm", "Error occurred: ${e}")
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Pokemon>
    ): PokemonRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                pokemonRemoteKeyDao.getRemoteKeys(id.toString())
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, Pokemon>
    ): PokemonRemoteKeys? {
        return state.pages.firstOrNull() { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { pokemon ->
                pokemonRemoteKeyDao.getRemoteKeys(pokemon.id.toString())
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, Pokemon>
    ): PokemonRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { pokemon ->
                pokemonRemoteKeyDao.getRemoteKeys(pokemon.id.toString())
            }
    }
}