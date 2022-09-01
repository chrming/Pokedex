package com.example.pokedex.screens.pokemonList.presentation

import android.util.Log
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pokedex.screens.pokemonList.domain.useCase.PokemonListUseCaseWrapper
import com.example.pokedex.screens.pokemonList.presentation.event.PokemonListEvent
import com.example.pokedex.screens.pokemonList.presentation.state.FilterState
import com.example.pokedex.screens.pokemonList.presentation.state.PokemonListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonListVM @Inject constructor(
    private val useCase: PokemonListUseCaseWrapper,
) : ViewModel() {

    var pokemonListState by mutableStateOf(PokemonListState())
        private set
    var filterState by mutableStateOf(FilterState())
        private set

    private var fetchJob: Job? = null

    init {
        fetchPokemonList()
    }

    fun onEvent(event: PokemonListEvent) {
        when (event) {
            is PokemonListEvent.FilterEvent.Type.FilterExpanded -> {
                filterState =
                    filterState.copy(
                        filterExpanded = filterState.filterExpanded.copy(
                            typeIsExpanded = event.expanded
                        )
                    )
            }
            is PokemonListEvent.FilterEvent.Type.FilterSelected -> {
                filterState =
                    filterState.copy(filterNames = filterState.filterNames.copy(type = event.filterName))
                if (event.filterName == "all") {
                    fetchPokemonList()
                } else {
                    // fetchPokemonListByType(event.filterName)
                }
            }
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
                if (event.filterName == "all") {
                    fetchPokemonList()
                } else {
                    //fetchPokemonListByVersion(event.filterName)
                }
            }
            is PokemonListEvent.FilterEvent.Name.OnChange -> {
                filterState =
                    filterState.copy(filterNames = filterState.filterNames.copy(name = event.filterName))
                if (event.filterName.isEmpty()) {
                    fetchPokemonList()
                } else {
                    //fetchPokemonListByName(event.filterName)
                }
            }
            PokemonListEvent.FilterEvent.ToggleFilterSection -> {
                filterState =
                    filterState.copy(isFilterSectionExpanded = !filterState.isFilterSectionExpanded)
            }
        }
    }

    private fun fetchPokemonList() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            pokemonListState = pokemonListState.copy(
                pokemonList = useCase.getPokemonList()
            )
        }
    }
}