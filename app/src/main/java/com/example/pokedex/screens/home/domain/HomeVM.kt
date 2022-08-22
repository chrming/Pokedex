package com.example.pokedex.screens.home.domain

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.pokedex.navigation.PokemonDetailScreenNavArgs
import com.example.pokedex.screens.home.domain.state.PokemonState
import com.example.pokedex.screens.home.domain.useCase.HomeUseCaseWrapper
import com.example.pokedex.screens.navArgs
import com.example.pokedex.screens.pokemonList.domain.PokemonListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeVM @Inject constructor(
    private val useCase: HomeUseCaseWrapper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val pokemonIdOrName: PokemonDetailScreenNavArgs = savedStateHandle.navArgs()

    private val _pokemonState = mutableStateOf(PokemonState())
    val pokemonState = _pokemonState

    private var fetchJob: Job? = null

    init {
        fetchPokemon(pokemonIdOrName.nameOrId)
    }

    private fun onEvent(event: PokemonListEvent) {

    }

    private fun fetchPokemon(idOrName: String) {
        fetchJob?.cancel()
        fetchJob = CoroutineScope(Dispatchers.IO).launch {
            useCase.getPokemon(idOrName = idOrName).also {
                _pokemonState.value = pokemonState.value.copy(pokemon = it)
            }
        }
    }
}