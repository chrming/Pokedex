package com.example.pokedex.screens.pokemonList.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.screens.pokemonList.domain.useCase.PokemonListUseCaseWrapper
import com.example.pokedex.screens.pokemonList.presentation.event.PokemonListEvent
import com.example.pokedex.screens.pokemonList.presentation.state.FilterState
import com.example.pokedex.screens.pokemonList.presentation.state.PokemonListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

//TODO after poping backstack (PokemonDetail -> PokemonList) pager loads 1'st page instead of the previous nth one

@HiltViewModel
class PokemonListVM @Inject constructor(
    private val useCase: PokemonListUseCaseWrapper,
) : ViewModel() {

    var pokemons: Flow<PagingData<Pokemon>> = useCase.getPokemonList()
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