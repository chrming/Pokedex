package com.example.pokedex.screens.pokemonDetail

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
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
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.navigation.PokemonDetailScreenNavArgs
import com.example.pokedex.screens.home.domain.HomeVM
import com.example.pokedex.screens.pokemonList.presentation.composable.colorByType
import com.example.pokedex.screens.pokemonList.presentation.composable.colorListByType
import com.example.pokedex.ui.theme.*
import com.ramcosta.composedestinations.annotation.Destination
import java.util.*

@Destination(navArgsDelegate = PokemonDetailScreenNavArgs::class)
@Composable
fun PokemonDetailScreen(
    viewModel: HomeVM = hiltViewModel(),
) {
    val pokemonState = viewModel.pokemonState.value.pokemon
    Log.d("chm", "$pokemonState")

    if (pokemonState != Pokemon()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(colorListByType(pokemonState.types[0]))
                ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4F)
                    .background(
                        Brush.verticalGradient(colorListByType(pokemonState.types[0]))
                    )

                    .border(1.dp, Black),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box() {
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
                    Box(contentAlignment = Alignment.BottomCenter ){
                        SubcomposeAsyncImage(
                            modifier = Modifier,
                            model = pokemonState.sprites.other.officialArtwork?.front_default,
                            contentDescription = null,
                            loading = {
                                CircularProgressIndicator()
                            }
                        )
                        Canvas(modifier = Modifier.fillMaxWidth(), onDraw = {
                           drawOval(Black, topLeft = Offset.Infinite)
                        })
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1F)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier
                            .background(colorByType(pokemonState.types[0]))
                            .border(1.dp, Black),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            modifier = Modifier
                                .width(400.dp)
                                .padding(horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "HP",
                                fontSize = 15.sp
                            )
                            LinearProgressIndicator(
                                modifier = Modifier
                                    .height(10.dp)
                                    .border(1.dp, Color.Black)
                                    .shadow(5.dp),
                                progress = pokemonState.stats[0].base_stat.toFloat() / Pokemon.maxHp.toFloat(),
                                color = Health
                            )
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
                            LinearProgressIndicator(
                                modifier = Modifier
                                    .height(10.dp)
                                    .border(1.dp, Color.Black)
                                    .shadow(5.dp),
                                progress = pokemonState.stats[1].base_stat.toFloat() / Pokemon.maxAttack.toFloat(),
                                color = Attack
                            )
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
                            LinearProgressIndicator(
                                modifier = Modifier
                                    .height(10.dp)
                                    .border(1.dp, Color.Black)
                                    .shadow(5.dp),
                                progress = pokemonState.stats[2].base_stat.toFloat() / Pokemon.maxDefense.toFloat(),
                                color = Defense
                            )
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
                        LinearProgressIndicator(
                            modifier = Modifier
                                .height(10.dp)
                                .border(1.dp, Color.Black)
                                .shadow(5.dp),
                            progress = pokemonState.stats[5].base_stat.toFloat() / Pokemon.maxSpeed.toFloat(),
                            color = Speed
                        )
                    }
                    }
                    Row(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(horizontal = 4.dp),
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
                                    // colors = ButtonDefaults.buttonColors(colorByType(it))
                                ) {
                                    Text(
                                        text = it.type.name.replaceFirstChar {
                                            if (it.isLowerCase()) it.titlecase(
                                                Locale.getDefault()
                                            ) else it.toString()
                                        },
                                        fontSize = 10.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}