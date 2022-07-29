package com.example.pokedex.pokemonList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedex.pokemonList.composable.PokemonListItem
import com.example.pokedex.pokemonList.composable.PokemonVerticalGrid

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonListScreen(
    viewModel: PokemonListVM = hiltViewModel()
) {
    val pokemonListState = viewModel.pokemonListState
    PokemonVerticalGrid(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 50.dp)
        ,
        pokemonList = pokemonListState.pokemonList)
}