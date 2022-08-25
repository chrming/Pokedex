package com.example.pokedex.screens.pokemonList.domain.pager

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedex.datasource.local.model.Pokemon
import com.example.pokedex.datasource.local.repository.IPokemonRepository
import com.example.pokedex.datasource.network.repository.IApiPokemonRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PokemonListPagingSource @Inject constructor(
    private val localRepo: IPokemonRepository,
    private val apiRepo: IApiPokemonRepository
) : PagingSource<Int, Pokemon>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        try {
            val pageNumber = params.key ?: 0
            val response = localRepo.getPokemonListPage(pageNumber, pageSize = 50)
            return LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = pageNumber.plus(1)
            )
        } catch (e: IOException) {
            Log.d("chm", "Page not loaded")
            // IOException for network failures.
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            // HttpException for any non-2xx HTTP status codes.
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
