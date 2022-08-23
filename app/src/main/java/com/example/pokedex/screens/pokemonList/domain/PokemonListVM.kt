package com.example.pokedex.screens.pokemonList.domain

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.screens.pokemonList.domain.useCase.PokemonListUseCaseWrapper
import com.example.pokedex.screens.pokemonList.presentation.event.PokemonListEvent
import com.example.pokedex.screens.pokemonList.presentation.state.FilterState
import com.example.pokedex.screens.pokemonList.presentation.state.PokemonListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class PokemonListVM @Inject constructor(
    private val useCase: PokemonListUseCaseWrapper
) : ViewModel() {

    var pokemonListState by mutableStateOf(PokemonListState())
        private set
    var pokemonGridState by mutableStateOf(LazyGridState())
        private set
    var filterState by mutableStateOf(FilterState())
        private set

    private var fetchJob: Job? = null

    init {
        fetchPokemonList()
    }

    fun onEvent(event: PokemonListEvent) {
        when (event) {
            is PokemonListEvent.FilterEvent.Version.FilterExpanded -> {
                filterState =
                    filterState.copy(
                        filterExpanded = filterState.filterExpanded.copy(
                            versionIsExpanded = event.expanded
                        )
                    )
            }
            is PokemonListEvent.FilterEvent.Version.FilterSelected -> {
                filterState =
                    filterState.copy(filterNames = filterState.filterNames.copy(version = event.filterName))
            }
            is PokemonListEvent.FilterEvent.Type.FilterExpanded -> {
                filterState =
                    filterState.copy(filterExpanded = filterState.filterExpanded.copy(typeIsExpanded = event.expanded))
            }
            is PokemonListEvent.FilterEvent.Type.FilterSelected -> {
                filterState =
                    filterState.copy(filterNames = filterState.filterNames.copy(type = event.filterName))
                if (event.filterName == "all"){
                    fetchPokemonList()
                } else {
                    fetchPokemonListByType(event.filterName)
                }
            }
        }
    }

    private fun fetchPokemonList() {
        fetchJob?.cancel()
        fetchJob = useCase.getPokemonList().onEach { pokemons ->
            pokemonListState = pokemonListState.copy(
                pokemonList = pokemons
            )
        }.launchIn(viewModelScope)
    }

    private fun fetchPokemonListByType(type: String) {
        fetchJob?.cancel()
        fetchJob = useCase.getPokemonList().onEach { pokemons ->
            pokemonListState = pokemonListState.copy(
                pokemonList = pokemons.filter { pokemon ->
                    pokemon.types.any { it.type.name == type }
                }
            )
        }.launchIn(viewModelScope)
    }
}
