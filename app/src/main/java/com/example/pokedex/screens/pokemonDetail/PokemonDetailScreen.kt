package com.example.pokedex.screens.pokemonDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.navigation.PokemonDetailScreenNavArgs
import com.example.pokedex.screens.pokemonDetail.presentation.PokemonDetailVM
import com.example.pokedex.screens.pokemonDetail.presentation.composables.PictureSection
import com.example.pokedex.screens.pokemonDetail.presentation.composables.SelectExtendedInfoSection
import com.example.pokedex.screens.pokemonDetail.presentation.composables.StatsSection
import com.example.pokedex.screens.pokemonDetail.presentation.composables.extendedInfoSection
import com.example.pokedex.screens.pokemonDetail.presentation.event.PokemonDetailEvent
import com.example.pokedex.screens.pokemonList.presentation.composable.colorByType
import com.example.pokedex.screens.pokemonList.presentation.composable.colorListByType
import com.ramcosta.composedestinations.annotation.Destination

//TODO Refactor

@Destination(navArgsDelegate = PokemonDetailScreenNavArgs::class)
@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailVM = hiltViewModel(),
) {
    val pokemonState = viewModel.pokemonState.value.pokemon
    val expanded = viewModel.pokemonState.value.expanded
    val pokemonInfo = viewModel.pokemonState.value.info
    val pokemonStats = viewModel.pokemonState.value.stats
    val onEvent: (PokemonDetailEvent) -> Unit = { viewModel.onEvent(it) }

    if (pokemonState != Pokemon()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.linearGradient(colorListByType(pokemonState.types[0])))
        ) {
            item {
                PictureSection(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp)
                        .padding(top = 10.dp)
                        .background(Brush.verticalGradient(colorListByType(pokemonState.types[0])))
                        .border(1.dp, Black),
                    pokemonName = pokemonState.name,
                    pokemonSpriteUrl = pokemonState.sprites.other.officialArtwork?.front_default
                        ?: "",
                    pictureSize = 250.dp,
                    fontSize = 40.sp
                )
            }
            item {
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(1F)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        StatsSection(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp)
                                .border(1.dp, Color.Black)
                                .background(
                                    colorByType(pokemonState.types[0])
                                ), pokemonStats = pokemonStats, pokemonTypes = pokemonState.types
                        )
                    }
                }
            }
            item {
                SelectExtendedInfoSection(
                    onClick = onEvent,
                    pokemonType = pokemonState.types[0],
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
            extendedInfoSection(
                pokemonInfo = pokemonInfo,
                expandedState = expanded,
                pokemonType = pokemonState.types[0]
            )
        }
    }
}