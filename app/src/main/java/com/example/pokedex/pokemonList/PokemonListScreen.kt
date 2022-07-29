package com.example.pokedex.pokemonList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonListScreen(
    viewModel: PokemonListVM = hiltViewModel()
){
    val pokemonListState = viewModel.pokemonListState
   LazyColumn(){
           items(items = pokemonListState.pokemonList) { pokemon ->
               Card() {
                  Text(text = pokemon.name)
               }
           }

   }
}