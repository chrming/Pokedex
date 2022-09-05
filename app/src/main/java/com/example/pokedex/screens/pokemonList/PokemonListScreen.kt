package com.example.pokedex.screens.pokemonList

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pokedex.screens.destinations.PokemonDetailScreenDestination
import com.example.pokedex.screens.pokemonList.presentation.PokemonListVM
import com.example.pokedex.screens.pokemonList.presentation.composable.PokemonLazyList
import com.example.pokedex.screens.pokemonList.presentation.composable.filterSection.FiltersSection
import com.example.pokedex.screens.pokemonList.presentation.event.PokemonListEvent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PokemonListScreen(
    viewModel: PokemonListVM = hiltViewModel(),
    navigator: DestinationsNavigator,
) {
    val pokemonListState = viewModel.pokemonListState.pokemonList.collectAsLazyPagingItems()
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
            AnimatedVisibility(visible = true) {
                FiltersSection(
                    Modifier
                )
            }
            PokemonLazyList(
                modifier = Modifier.fillMaxSize(),
                pokemonList = pokemonListState,
                onItemClick = { pokemon ->
                    navigator.navigate(PokemonDetailScreenDestination(pokemon.name))
                }
            )
        }
    }
}