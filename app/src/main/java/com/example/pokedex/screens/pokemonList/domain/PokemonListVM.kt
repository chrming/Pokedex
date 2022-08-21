package com.example.pokedex.screens.pokemonList.domain

import android.util.Log
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.screens.pokemonList.domain.state.PokemonListState
import com.example.pokedex.screens.pokemonList.domain.useCase.PokemonListUseCaseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class PokemonListVM @Inject constructor(
    private val useCase: PokemonListUseCaseWrapper
) : ViewModel() {

    private val _pokemonListState = mutableStateOf(PokemonListState())
    val pokemonListState = _pokemonListState

    var pokemonGridState by mutableStateOf(LazyGridState())
        private set

    private var fetchJob: Job? = null

    init {
        fetchPokemonList()
    }

    private fun onEvent(event: PokemonListEvent) {

    }

    private fun fetchPokemonList() {
        fetchJob?.cancel()
        fetchJob = useCase.getPokemonList().onEach { pokemons ->
            _pokemonListState.value = pokemonListState.value.copy(
                pokemonList = pokemons
            )
        }.launchIn(viewModelScope)
    }
}