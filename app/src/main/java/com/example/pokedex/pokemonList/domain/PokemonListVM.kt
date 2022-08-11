package com.example.pokedex.pokemonList.domain

import android.util.Log
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.pokemonList.domain.state.PokemonListState
import com.example.pokedex.pokemonList.domain.useCase.PokemonListUseCaseWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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
    var pokemonGridState by mutableStateOf(LazyGridState())
        private set

    private var fetchJob: Job? = null

    init {
        fetchPokemonList()
        Log.d("chm", "fetchPokemonList()")
    }

    private fun onEvent(event: PokemonListEvent){
        
    }

    private fun fetchPokemonList() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                pokemonListState = pokemonListState.copy(pokemonList = useCase.getPokemonList())
            } catch (ioe: IOException) {
                //Handle error
            }
        }
    }
}