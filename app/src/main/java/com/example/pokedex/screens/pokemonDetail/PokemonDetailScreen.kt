package com.example.pokedex.screens.pokemonDetail

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
import com.example.pokedex.screens.pokemonDetail.presentation.event.PokemonDetailEvent
import com.example.pokedex.screens.pokemonDetail.state.ExpandedState
import com.example.pokedex.screens.pokemonList.presentation.composable.PokemonLazyList
import com.example.pokedex.screens.pokemonList.presentation.composable.colorByType
import com.example.pokedex.screens.pokemonList.presentation.composable.colorListByType
import com.example.pokedex.ui.theme.*
import com.ramcosta.composedestinations.annotation.Destination
import java.util.*

@Destination(navArgsDelegate = PokemonDetailScreenNavArgs::class)
@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailVM = hiltViewModel(),
) {
    val pokemonState = viewModel.pokemonState.value.pokemon
    val expanded = viewModel.pokemonState.value.expanded
    val onEvent: (PokemonDetailEvent) -> Unit = { viewModel.onEvent(it) }

    if (pokemonState != Pokemon()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(colorListByType(pokemonState.types[0]))
                ),
        ) {

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

            Spacer(modifier = Modifier.height(5.dp))

            // Box containing stats
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

                    // Stats progress bar column

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .background(colorByType(pokemonState.types[0]))
                            .border(1.dp, Black),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            modifier = Modifier
                                .width(400.dp)
                                .padding(horizontal = 10.dp)
                                .padding(top = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "HP",
                                fontSize = 15.sp
                            )
                            Box(contentAlignment = Alignment.CenterStart) {
                                LinearProgressIndicator(
                                    modifier = Modifier
                                        .height(10.dp)
                                        .border(1.dp, Color.Black)
                                        .shadow(5.dp),
                                    progress = pokemonState.stats[0].base_stat.toFloat() / Pokemon.maxHp.toFloat(),
                                    color = Health
                                )
                                Text(
                                    modifier = Modifier.padding(start = 2.dp),
                                    text = "${pokemonState.stats[0].base_stat} / ${Pokemon.maxHp}",
                                    fontSize = 8.sp,
                                    color = Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .width(400.dp)
                                .padding(horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "ATK",
                                fontSize = 15.sp
                            )
                            Box(contentAlignment = Alignment.CenterStart) {
                                LinearProgressIndicator(
                                    modifier = Modifier
                                        .height(10.dp)
                                        .border(1.dp, Color.Black)
                                        .shadow(5.dp),
                                    progress = pokemonState.stats[1].base_stat.toFloat() / Pokemon.maxAttack.toFloat(),
                                    color = Attack
                                )
                                Text(
                                    modifier = Modifier.padding(start = 2.dp),
                                    text = "${pokemonState.stats[1].base_stat} / ${Pokemon.maxAttack}",
                                    fontSize = 8.sp,
                                    color = Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .width(400.dp)
                                .padding(horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "DEF",
                                fontSize = 15.sp
                            )
                            Box(contentAlignment = Alignment.CenterStart) {
                                LinearProgressIndicator(
                                    modifier = Modifier
                                        .height(10.dp)
                                        .border(1.dp, Color.Black)
                                        .shadow(5.dp),
                                    progress = pokemonState.stats[2].base_stat.toFloat() / Pokemon.maxDefense.toFloat(),
                                    color = Defense
                                )
                                Text(
                                    modifier = Modifier.padding(start = 2.dp),
                                    text = "${pokemonState.stats[2].base_stat} / ${Pokemon.maxDefense}",
                                    fontSize = 8.sp,
                                    color = Black
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .width(400.dp)
                                .padding(horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "SPD",
                                fontSize = 15.sp
                            )
                            Box(contentAlignment = Alignment.CenterStart) {
                                LinearProgressIndicator(
                                    modifier = Modifier
                                        .height(10.dp)
                                        .border(1.dp, Color.Black)
                                        .shadow(5.dp),
                                    progress = pokemonState.stats[5].base_stat.toFloat() / Pokemon.maxSpeed.toFloat(),
                                    color = Speed
                                )
                                Text(
                                    modifier = Modifier.padding(start = 2.dp),
                                    text = "${pokemonState.stats[5].base_stat} / ${Pokemon.maxSpeed}",
                                    fontSize = 8.sp,
                                    color = Black
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .width(400.dp)
                                .padding(horizontal = 10.dp)
                                .padding(bottom = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "TYPE",
                                fontSize = 10.sp
                            )
                            Row() {
                                pokemonState.types.forEach {
                                    TextButton(
                                        modifier = Modifier
                                            .padding(2.dp)
                                            .width(50.dp)
                                            .height(20.dp),
                                        onClick = {/*TODO filter by this chip*/ },
                                        border = BorderStroke(1.dp, Color.Black),
                                        contentPadding = PaddingValues(2.dp),
                                        colors = ButtonDefaults.buttonColors(colorByType(it))
                                    ) {
                                        Text(
                                            text = it.type.name.replaceFirstChar { char ->
                                                if (char.isLowerCase()) char.titlecase(
                                                    Locale.getDefault()
                                                ) else char.toString()
                                            },
                                            fontSize = 10.sp
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    // Info section to open more info:
                    //  - Abilities list
                    //  - Moves
                    //  - Held items list
                    //  - Where to find
                    //  - Sprites section

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .background(colorByType(pokemonState.types[0]))
                            .border(1.dp, Black),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Row(
                                modifier = Modifier
                                    .width(400.dp)
                                    .padding(5.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                TextButton(
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .width(75.dp)
                                        .height(25.dp),
                                    onClick = { onEvent(PokemonDetailEvent.Expanded.Abilities) },
                                    border = BorderStroke(1.dp, Color.Black),
                                    contentPadding = PaddingValues(2.dp),
                                ) {
                                    Text(
                                        text = "Abilities",
                                        fontSize = 10.sp,
                                        color = Black
                                    )
                                }
                                TextButton(
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .width(75.dp)
                                        .height(25.dp),
                                    onClick = { onEvent(PokemonDetailEvent.Expanded.Moves) },
                                    border = BorderStroke(1.dp, Color.Black),
                                    contentPadding = PaddingValues(2.dp),
                                ) {
                                    Text(
                                        text = "Moves",
                                        fontSize = 10.sp,
                                        color = Black
                                    )
                                }
                                TextButton(
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .width(75.dp)
                                        .height(25.dp),
                                    onClick = { onEvent(PokemonDetailEvent.Expanded.Sprites) },
                                    border = BorderStroke(1.dp, Color.Black),
                                    contentPadding = PaddingValues(2.dp),
                                ) {
                                    Text(
                                        text = "Sprites",
                                        fontSize = 10.sp,
                                        color = Black
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Row(
                                modifier = Modifier
                                    .width(400.dp)
                                    .padding(5.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                TextButton(
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .width(75.dp)
                                        .height(25.dp),
                                    onClick = { onEvent(PokemonDetailEvent.Expanded.AreaEncounter) },
                                    border = BorderStroke(1.dp, Color.Black),
                                    contentPadding = PaddingValues(2.dp),
                                ) {
                                    Text(
                                        text = "Location",
                                        fontSize = 10.sp,
                                        color = Black
                                    )
                                }
                                TextButton(
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .width(75.dp)
                                        .height(25.dp),
                                    onClick = { onEvent(PokemonDetailEvent.Expanded.HeldItem) },
                                    border = BorderStroke(1.dp, Color.Black),
                                    contentPadding = PaddingValues(2.dp),
                                ) {
                                    Text(
                                        text = "Held Items",
                                        fontSize = 10.sp,
                                        color = Black
                                    )
                                }
                            }
                        }
                    }
                    when (expanded) {
                        ExpandedState(abilities = true) -> {
                            Spacer(modifier = Modifier.height(5.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                                    .background(colorByType(pokemonState.types[0]))
                                    .border(1.dp, Black),
                                verticalArrangement = Arrangement.SpaceAround,
                                horizontalAlignment = Alignment.Start
                            ) {
                                DropdownMenu(
                                    expanded = expanded.abilities,
                                    onDismissRequest = { onEvent(PokemonDetailEvent.Expanded.Abilities) }) {
                                    pokemonState.abilities.forEach {
                                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                                            Text(text = it.ability.name)
                                        }
                                    }
                                }
                            }
                        }
                        ExpandedState(moves = true) -> {
                            Spacer(modifier = Modifier.height(5.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                                    .background(colorByType(pokemonState.types[0]))
                                    .border(1.dp, Black),
                                verticalArrangement = Arrangement.SpaceAround,
                                horizontalAlignment = Alignment.Start
                            ) {
                                DropdownMenu(
                                    expanded = expanded.moves,
                                    onDismissRequest = { onEvent(PokemonDetailEvent.Expanded.Moves) }) {
                                    pokemonState.moves.forEach {
                                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                                            Text(text = it.move.name)
                                        }
                                    }
                                }
                            }
                        }
                        ExpandedState(sprites = true) -> {
                            Spacer(modifier = Modifier.height(5.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                                    .background(colorByType(pokemonState.types[0]))
                                    .border(1.dp, Black),
                                verticalArrangement = Arrangement.SpaceAround,
                                horizontalAlignment = Alignment.Start
                            ) {
                                DropdownMenu(
                                    expanded = expanded.sprites,
                                    onDismissRequest = { onEvent(PokemonDetailEvent.Expanded.Sprites) }) {
                                    // TODO open new screen where user can choose a version and see sprites
                                }
                            }
                        }
                        ExpandedState(areaEncounter = true) -> {
                            Spacer(modifier = Modifier.height(5.dp))
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                                    .background(colorByType(pokemonState.types[0]))
                                    .border(1.dp, Black),
                                verticalArrangement = Arrangement.SpaceAround,
                                horizontalAlignment = Alignment.Start
                            ) {
                                DropdownMenu(
                                    expanded = expanded.areaEncounter,
                                    onDismissRequest = { onEvent(PokemonDetailEvent.Expanded.AreaEncounter) }) {
                                    pokemonState.location_area_encounters.forEach {
                                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                                            // TODO show a list of areas (possibility of growing an app)
                                        }
                                    }
                                }
                            }
                        }
                        ExpandedState(heldItem = true) -> {
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(text = ("ONION"))
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                                    .background(colorByType(pokemonState.types[0]))
                                    .border(1.dp, Black),
                                verticalArrangement = Arrangement.SpaceAround,
                                horizontalAlignment = Alignment.Start
                            ) {
                                items(pokemonState.held_items) {
                                    Text(text = it.item.name)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}