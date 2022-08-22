package com.example.pokedex.screens.pokemonList.domain

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.screens.pokemonList.domain.state.FilterState
import com.example.pokedex.screens.pokemonList.domain.state.PokemonListState
import com.example.pokedex.screens.pokemonList.domain.useCase.PokemonListUseCaseWrapper
import com.example.pokedex.screens.pokemonList.ui.composable.filter.FilterExpanded
import com.example.pokedex.screens.pokemonList.ui.composable.filter.FilterNames
import com.example.pokedex.screens.pokemonList.util.pokemonFilters.Filter
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

    var filterState by mutableStateOf(FilterState())
        private set

    private var fetchJob: Job? = null

    init {
        fetchPokemonList()
    }

    fun onEvent(event: PokemonListEvent) {
        when (event) {
            is PokemonListEvent.FilterEvent.FilterBy -> {
                filterState = when (event.filter) {
                    Filter.Type -> {
                        filterState.copy(filterNames = FilterNames(type = event.filterName))
                    }
                    Filter.Version -> {
                        filterState.copy(filterNames = FilterNames(version = event.filterName))
                    }
                }
            }
            is PokemonListEvent.FilterEvent.FilterExpanded -> {
                filterState = when (event.filterType) {
                    Filter.Type -> {
                        filterState.copy(filterExpanded = FilterExpanded(typeIsExpanded = !filterState.filterExpanded.typeIsExpanded))
                    }
                    Filter.Version -> {
                        filterState.copy(filterExpanded = FilterExpanded(versionIsExpanded = !filterState.filterExpanded.versionIsExpanded))
                    }
                }

            }
        }
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