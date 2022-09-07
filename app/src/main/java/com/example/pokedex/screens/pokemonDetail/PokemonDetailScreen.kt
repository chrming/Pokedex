package com.example.pokedex.screens.pokemonDetail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.navigation.PokemonDetailScreenNavArgs
import com.example.pokedex.screens.pokemonDetail.presentation.PokemonDetailVM
import com.example.pokedex.screens.pokemonDetail.presentation.composables.SelectExtendedInfoSection
import com.example.pokedex.screens.pokemonDetail.presentation.composables.StatsSection
import com.example.pokedex.screens.pokemonDetail.presentation.composables.extendedInfoSection
import com.example.pokedex.screens.pokemonDetail.presentation.event.PokemonDetailEvent
import com.example.pokedex.screens.pokemonList.presentation.composable.colorListByType
import com.example.pokedex.ui.theme.PokemonTypography
import com.ramcosta.composedestinations.annotation.Destination
import java.util.*

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
                // Box containing picture
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4F),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 10.dp)
                            .padding(top = 10.dp)
                            .background(Brush.verticalGradient(colorListByType(pokemonState.types[0])))
                            .border(1.dp, Black),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                        // contentAlignment = Alignment.TopCenter
                    ) {
                        Box(
                            contentAlignment = Alignment.BottomCenter,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            SubcomposeAsyncImage(
                                modifier = Modifier.size(250.dp),
                                model = pokemonState.sprites.other.officialArtwork?.front_default,
                                contentDescription = null,
                                loading = {
                                    CircularProgressIndicator()
                                }
                            )
                            Canvas(modifier = Modifier.fillMaxWidth(), onDraw = {
                                drawOval(
                                    Black,
                                    topLeft = Offset.Infinite
                                )//TODO shadow under pokemon pic
                            })
                            Box(contentAlignment = Alignment.BottomCenter) {
                                Text(
                                    modifier = Modifier,
                                    text = pokemonState.name.replaceFirstChar {
                                        if (it.isLowerCase()) it.titlecase(
                                            Locale.getDefault()
                                        ) else it.toString()
                                    },
                                    style = PokemonTypography.body1,
                                    color = Color.White,
                                    letterSpacing = 1.sp,
                                    fontSize = 40.sp
                                )
                                Text(
                                    modifier = Modifier,
                                    text = pokemonState.name.replaceFirstChar {
                                        if (it.isLowerCase()) it.titlecase(
                                            Locale.getDefault()
                                        ) else it.toString()
                                    },
                                    style = PokemonTypography.h1,
                                    color = Color.Black,
                                    letterSpacing = 1.sp,
                                    fontSize = 40.sp
                                )
                            }
                        }
                    }
                }
            }
            item {
                StatsSection(pokemonStats = pokemonStats, pokemonTypes = pokemonState.types)
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