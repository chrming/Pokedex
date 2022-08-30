package com.example.pokedex.screens.pokemonList

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pokedex.screens.destinations.PokemonDetailScreenDestination
import com.example.pokedex.screens.pokemonList.presentation.PokemonListVM
import com.example.pokedex.screens.pokemonList.presentation.event.PokemonListEvent
import com.example.pokedex.screens.pokemonList.presentation.composable.filterSection.FiltersSection
import com.example.pokedex.screens.pokemonList.presentation.composable.PokemonVerticalGrid
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PokemonListScreen(
    viewModel: PokemonListVM = hiltViewModel(),
    navigator: DestinationsNavigator,
) {
    val pokemonListState = viewModel.pokemonListState.pokemonList.collectAsLazyPagingItems()
    val pokemonGridState = viewModel.pokemonGridState
    val filterState = viewModel.filterState

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                shape = RectangleShape,
                onClick = { viewModel.onEvent(PokemonListEvent.FilterEvent.ToggleFilterSection) }) {
                when (filterState.isFilterSectionExpanded) {
                    true -> {
                        Icon(
                            Icons.Default.ArrowDropUp,
                            contentDescription = "Toggle filter section"
                        )
                    }
                    false -> {
                        Icon(
                            Icons.Default.FilterAlt,
                            contentDescription = "Toggle filter section"
                        )
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {


            AnimatedVisibility(visible = filterState.isFilterSectionExpanded) {
                FiltersSection(
                    Modifier
                        .padding(2.dp),
                    filterState,
                    onEvent = { event -> viewModel.onEvent(event) }
                )
            }
            PokemonVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                pokemonList = pokemonListState,
                pokemonGridState = pokemonGridState,
                onItemClick = { pokemon ->
                    navigator.navigate(PokemonDetailScreenDestination(pokemon.name))
                }
            )
        }
    }
}