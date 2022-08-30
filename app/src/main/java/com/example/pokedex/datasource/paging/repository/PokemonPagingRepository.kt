package com.example.pokedex.datasource.paging.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pokedex.const.Constants.ITEM_PER_PAGE
import com.example.pokedex.datasource.local.db.PokemonDatabase
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.network.PokemonApi
import com.example.pokedex.datasource.network.repository.IPokemonApiRepository
import com.example.pokedex.datasource.paging.PokemonRemoteMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@OptIn(ExperimentalPagingApi::class)
class PokemonPagingRepository @Inject constructor(
    private val pokemonApi: IPokemonApiRepository,
    private val pokemonDatabase: PokemonDatabase
) {

    fun getAllPokemons(): Flow<PagingData<Pokemon>> {
        val pagingSourceFactory = { pokemonDatabase.pokemonDao().getAllPokemons() }
        return Pager(
            config = PagingConfig(pageSize = ITEM_PER_PAGE),
            remoteMediator = PokemonRemoteMediator(pokemonApi, pokemonDatabase),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}