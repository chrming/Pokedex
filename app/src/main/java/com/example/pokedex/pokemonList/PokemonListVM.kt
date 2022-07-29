package com.example.pokedex.pokemonList

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.network.model.pokemon.Pokemon
import com.example.pokedex.pokemonList.state.PokemonListState
import com.example.pokedex.pokemonList.useCase.PokemonListUseCaseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class PokemonListVM @Inject constructor(
    private val useCase: PokemonListUseCaseWrapper
) : ViewModel() {

    var pokemonListState by mutableStateOf(PokemonListState())
        private set

    private var fetchJob: Job? = null

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val pokemonResponseList = useCase.getPokemonList()
                val pokemonList = mutableListOf<Pokemon>()
                for (pokemon in pokemonResponseList.results) {
                    pokemonList.add(useCase.getPokemonListItem(pokemon.url.drop(34)))
                    //TODO change 34 to length of BASE_URL
                }
                pokemonListState = pokemonListState.copy(pokemonList = pokemonList)
                //TODO what if response is null
            } catch (ioe: IOException) {
                //Handle error
            }
        }
    }
}