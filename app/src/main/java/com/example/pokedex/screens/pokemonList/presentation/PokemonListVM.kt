package com.example.pokedex.screens.pokemonList.presentation

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.pokedex.screens.pokemonList.domain.useCase.PokemonListUseCaseWrapper
import com.example.pokedex.screens.pokemonList.domain.pager.PokemonListPagingSource
import com.example.pokedex.screens.pokemonList.domain.pager.PokemonListRemoteMediator
import com.example.pokedex.screens.pokemonList.presentation.event.PokemonListEvent
import com.example.pokedex.screens.pokemonList.presentation.state.FilterState
import com.example.pokedex.screens.pokemonList.presentation.state.PokemonListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonListVM @Inject constructor(
    private val useCase: PokemonListUseCaseWrapper,
    private val pageSource: PokemonListPagingSource,
    private val remoteMediator: PokemonListRemoteMediator
) : ViewModel() {

    @OptIn(ExperimentalPagingApi::class)
    private val pager = Pager(
        config = PagingConfig(50),
        remoteMediator = remoteMediator
    ) {
        pageSource
    }.flow.cachedIn(viewModelScope)

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
                    fetchPokemonListByType(event.filterName)
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
                    fetchPokemonListByVersion(event.filterName)
                }
            }
            is PokemonListEvent.FilterEvent.Name.OnChange -> {
                filterState =
                    filterState.copy(filterNames = filterState.filterNames.copy(name = event.filterName))
                if (event.filterName.isEmpty()) {
                    fetchPokemonList()
                } else {
                    fetchPokemonListByName(event.filterName)
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
        fetchJob =
            viewModelScope.launch {
         pager.collect() {
             it.
                    pokemonListState = pokemonListState.copy(pokemonList = it.filter
                    )
                }
            }
    }

    private fun fetchPokemonListByType(type: String) {
        fetchJob?.cancel()
        fetchJob =
            viewModelScope.launch {
                useCase.getPokemonList()
                    .map { pokemons ->
                        pokemons.filter { pokemon -> pokemon.types.any { it.type.name == type } }
                    }
                    .collect() { newPokemonList ->
                        pokemonListState = pokemonListState.copy(pokemonList = newPokemonList)
                    }
            }
    }


    private fun fetchPokemonListByVersion(version: String) {
        fetchJob?.cancel()
        fetchJob =
            viewModelScope.launch {
                useCase.getPokemonList()
                    .map { pokemons ->
                        pokemons.filter { pokemon -> pokemon.game_indices.any { it.version.name == version } }
                    }
                    .collect { newPokemonList ->
                        pokemonListState = pokemonListState.copy(pokemonList = newPokemonList)
                    }
            }
    }

    private fun fetchPokemonListByName(name: String) { //TODO Kills app. Add Confirm button
        fetchJob?.cancel()
        fetchJob = useCase.getPokemonList()
            .map { pokemons ->
                pokemons.filter { pokemon -> pokemon.name.startsWith(name) }
            }
            .onEach { pokemons ->
                pokemonListState = pokemonListState.copy(
                    pokemonList = pokemons
                )
            }.launchIn(viewModelScope)
    }
}
//TODO improve fetching pokemons