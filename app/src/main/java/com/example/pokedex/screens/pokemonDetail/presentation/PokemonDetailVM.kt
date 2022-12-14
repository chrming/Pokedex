package com.example.pokedex.screens.pokemonDetail.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.pokedex.datasource.model.pokemonAttributes.Attribute
import com.example.pokedex.navigation.PokemonDetailScreenNavArgs
import com.example.pokedex.screens.navArgs
import com.example.pokedex.screens.pokemonDetail.domain.useCase.PokemonDetailUseCaseWrapper
import com.example.pokedex.screens.pokemonDetail.presentation.event.PokemonDetailEvent
import com.example.pokedex.screens.pokemonDetail.presentation.state.PokemonExtendedInfo
import com.example.pokedex.screens.pokemonDetail.presentation.state.PokemonStats
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

    private val pokemonPassedName: PokemonDetailScreenNavArgs = savedStateHandle.navArgs()

    private val _pokemonState = mutableStateOf(PokemonState())
    val pokemonState = _pokemonState

    private var fetchJob: Job? = null

    init {
        fetchPokemon(pokemonPassedName.name)
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
    }

    private fun fetchPokemon(name: String) {
        fetchJob?.cancel()
        fetchJob = CoroutineScope(Dispatchers.IO).launch {
            useCase.getPokemonByName(name = pokemonPassedName.name).also { pokemon ->
                _pokemonState.value = pokemonState.value.copy(
                    pokemon = pokemon,
                    info = PokemonExtendedInfo(
                        abilities = pokemon.abilities.map { ability ->
                            Attribute(name = ability.ability.name, url = ability.ability.url)
                        }.sortedBy { it.name },
                        moves = pokemon.moves.map { move ->
                            Attribute(name = move.move.name, url = move.move.url)
                        }.sortedBy { it.name },
                        sprites = emptyList(), //TODO transform Sprites -> List<Attribute>
                        location = emptyList(), //TODO transform String -> List<Attribute> make api call
                        heldItems = pokemon.held_items.map { heldItem ->
                            Attribute(name = heldItem.item.name, url = heldItem.item.url)
                        }.sortedBy { it.name }
                    ),
                    stats = PokemonStats(
                        health = pokemon.stats[0].base_stat,
                        attack = pokemon.stats[1].base_stat,
                        defense = pokemon.stats[2].base_stat,
                        speed = pokemon.stats[5].base_stat
                    )
                )
            }
        }
    }
}
