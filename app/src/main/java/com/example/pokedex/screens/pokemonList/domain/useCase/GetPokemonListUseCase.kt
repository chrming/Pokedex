package com.example.pokedex.screens.pokemonList.domain.useCase

import androidx.paging.PagingData
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.paging.repository.PokemonPagingRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonListUseCase(
    private val repository: PokemonPagingRepository
) {
    operator fun invoke(): Flow<PagingData<Pokemon>> {
        return repository.getAllPokemons()
    }
}
