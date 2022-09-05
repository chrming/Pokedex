package com.example.pokedex.screens.pokemonDetail.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.pokedex.navigation.PokemonDetailScreenNavArgs
import com.example.pokedex.screens.navArgs
import com.example.pokedex.screens.pokemonDetail.domain.useCase.PokemonDetailUseCaseWrapper
import com.example.pokedex.screens.pokemonDetail.presentation.event.PokemonDetailEvent
import com.example.pokedex.screens.pokemonDetail.state.ExpandedState
import com.example.pokedex.screens.pokemonDetail.state.PokemonState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailVM @Inject constructor(
    private val useCase: PokemonDetailUseCaseWrapper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val pokemonIdOrName: PokemonDetailScreenNavArgs = savedStateHandle.navArgs()

    private val _pokemonState = mutableStateOf(PokemonState())
    val pokemonState = _pokemonState

    private var fetchJob: Job? = null

    init {
        fetchPokemon(pokemonIdOrName.nameOrId)
    }

    fun onEvent(event: PokemonDetailEvent) {
        when (event) {
            is PokemonDetailEvent.Expanded.Abilities -> {
                _pokemonState.value =
                    pokemonState.value.copy(expanded = ExpandedState(abilities = !pokemonState.value.expanded.abilities))
            }
            is PokemonDetailEvent.Expanded.AreaEncounter -> {
                _pokemonState.value =
                    pokemonState.value.copy(expanded = ExpandedState(areaEncounter = !pokemonState.value.expanded.areaEncounter))
            }
            is PokemonDetailEvent.Expanded.HeldItem -> {
                _pokemonState.value =
                    pokemonState.value.copy(expanded = ExpandedState(heldItem = !pokemonState.value.expanded.heldItem))
            }
            is PokemonDetailEvent.Expanded.Moves -> {
                _pokemonState.value =
                    pokemonState.value.copy(expanded = ExpandedState(moves = !pokemonState.value.expanded.moves))
            }
            is PokemonDetailEvent.Expanded.Sprites -> {
                _pokemonState.value =
                    pokemonState.value.copy(expanded = ExpandedState(sprites = !pokemonState.value.expanded.sprites))
            }
        }
        Log.d("chm", "${pokemonState.value.expanded}")
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
