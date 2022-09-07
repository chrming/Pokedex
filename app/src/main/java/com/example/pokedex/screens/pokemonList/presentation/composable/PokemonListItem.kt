package com.example.pokedex.screens.pokemonList.presentation.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.model.pokemonAttributes.Type
import com.example.pokedex.ui.theme.*
import java.util.*


//TODO manage error and loading with assets
//TODO add fixed size of image
//TODO Refactor
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonListItem(
    modifier: Modifier = Modifier,
    pokemon: Pokemon,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(120.dp)
            .fillMaxWidth()
            .border(1.dp, Black),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colorListByType(pokemon.types[0])
                    )
                )
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Box(
                    contentAlignment = Alignment.BottomCenter
                ) {
                    SubcomposeAsyncImage(
                        modifier = Modifier.background(colorByType(pokemon.types[0])),
                        model = pokemon.sprites.other.officialArtwork?.front_default,
                        contentDescription = null,
                        loading = {
                            CircularProgressIndicator()
                        },
                        error = {

                            Icon(imageVector = Icons.Default.Error, contentDescription = null)
                        }
                    )
                    Box() {
                        Text(
                            modifier = Modifier,
                            text = pokemon.name.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.getDefault()
                                ) else it.toString()
                            },
                            style = PokemonTypography.body1,
                            color = White,
                            letterSpacing = 1.sp
                        )
                        Text(
                            modifier = Modifier,
                            text = pokemon.name.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.getDefault()
                                ) else it.toString()
                            },
                            style = PokemonTypography.h1,
                            color = Black,
                            letterSpacing = 1.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.width(4.dp))
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.Start
                ) {
                    Column(
                        modifier = Modifier,
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            modifier = Modifier
                                .width(300.dp)
                                .padding(horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "HP",
                                fontSize = 10.sp
                            )
                            LinearProgressIndicator(
                                modifier = Modifier
                                    .height(6.dp)
                                    .border(1.dp, Black)
                                    .shadow(5.dp),
                                progress = pokemon.stats[0].base_stat.toFloat() / Pokemon.maxHp.toFloat(),
                                color = Health
                            )
                            /*Text(
                                text = "${pokemon.stats[0].base_stat} / ${Pokemon.maxHp}",
                                fontSize = 12.sp
                            )*/
                        }
                        Row(
                            modifier = Modifier
                                .width(300.dp)
                                .padding(horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "ATK",
                                fontSize = 10.sp
                            )
                            LinearProgressIndicator(
                                modifier = Modifier
                                    .height(6.dp)
                                    .border(1.dp, Black)
                                    .shadow(5.dp),
                                progress = pokemon.stats[1].base_stat.toFloat() / Pokemon.maxAttack.toFloat(),
                                color = Attack
                            )
                            /*Text(
                                text = "${pokemon.stats[1].base_stat} / ${Pokemon.maxAttack}",
                                fontSize = 12.sp
                            )*/
                        }
                        Row(
                            modifier = Modifier
                                .width(300.dp)
                                .padding(horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "DEF",
                                fontSize = 10.sp
                            )
                            LinearProgressIndicator(
                                modifier = Modifier
                                    .height(6.dp)
                                    .border(1.dp, Black)
                                    .shadow(5.dp),
                                progress = pokemon.stats[2].base_stat.toFloat() / Pokemon.maxDefense.toFloat(),
                                color = Defense
                            )
                            /*Text(
                                text = "${pokemon.stats[2].base_stat} / ${Pokemon.maxDefense}",
                                fontSize = 12.sp
                            )*/
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
                            pokemon.types.forEach {
                                TextButton(
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .width(50.dp)
                                        .height(20.dp),
                                    onClick = {/*TODO filter by this chip*/ },
                                    border = BorderStroke(1.dp, Black),
                                    contentPadding = PaddingValues(2.dp),
                                    colors = ButtonDefaults.buttonColors(colorByType(it))
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

fun colorByType(pokemonType: Type): Color {
    return when (pokemonType.type.name) {
        "fighting" -> {
            //Color(113, 53, 50)
            Fighting
        }
        "flying" -> {
            //Color(66, 59, 90)
            Flying
        }
        "poison" -> {
            //Color(104, 64, 104)
            Poison
        }
        "ground" -> {
            //Color(114, 101, 62)
            Ground
        }
        "rock" -> {
            //Color(137, 127, 84)
            Rock
        }
        "bug" -> {
            //Color(134, 141, 78)
            Bug
        }
        "ghost" -> {
            //Color(87, 76, 103)
            Ghost
        }
        "steel" -> {
            //Color(66, 66, 82)
            Steel
        }
        "fire" -> {
            //Color(140, 91, 55)
            Fire
        }
        "water" -> {
            //Color(40, 63, 118)
            Water
        }
        "grass" -> {
            //Color(110, 136, 84)
            Grass
        }
        "electric" -> {
            //Color(171, 152, 74)
            Electric
        }
        "psychic" -> {
            //Color(124, 31, 59)
            Psychic
        }
        "ice" -> {
            //Color(79, 120, 120)
            Ice
        }
        "dragon" -> {
            //Color(52, 23, 119)
            Dragon
        }
        "dark" -> {
            //Color(85, 74, 68)
            Dark
        }
        "fairy" -> {
            //Color(98, 46, 98)
            Fairy
        }
        "unknown" -> {
            //Color(110, 110, 89)
            Normal

        }
        "shadow" -> {
            //Color(110, 110, 89)
            Normal

        }
        else -> {
            //Color(110, 110, 89)
            Normal
        }
    }
}

fun colorListByType(pokemonType: Type): List<Color> {
    return when (pokemonType.type.name) {
        "fighting" -> {
            listOf(
                LightFighting,
                Fighting
            )
        }
        "flying" -> {
            listOf(
                LightFlying,
                Flying
            )
        }
        "poison" -> {
            listOf(
                LightPoison,
                Poison
            )
        }
        "ground" -> {
            listOf(
                LightGround,
                Ground
            )
        }
        "rock" -> {
            listOf(
                LightRock,
                Rock
            )
        }
        "bug" -> {
            listOf(
                LightBug,
                Bug
            )
        }
        "ghost" -> {
            listOf(
                LightGhost,
                Ghost
            )
        }
        "steel" -> {
            listOf(
                LightSteel,
                Steel
            )
        }
        "fire" -> {
            listOf(
                LightFire,
                Fire
            )
        }
        "water" -> {
            listOf(
                LightWater,
                Water     //0xFF2648DC
            )
        }
        "grass" -> {
            listOf(
                LightGrass,
                Grass
            )
        }
        "electric" -> {
            listOf(
                LightElectric,
                Electric
            )
        }
        "psychic" -> {
            listOf(
                LightPsychic,
                Psychic
            )
        }
        "ice" -> {
            listOf(
                LightIce,
                Ice
            )
        }
        "dragon" -> {
            listOf(
                LightDragon,
                Dragon
            )
        }
        "dark" -> {
            listOf(
                LightDark,
                Dark
            )
        }
        "fairy" -> {
            listOf(
                LightFairy,
                Fairy
            )
        }
        "unknown" -> {
            listOf(
                LightNormal,
                Normal
            )

        }
        "shadow" -> {
            listOf(
                LightNormal,
                Normal
            )

        }
        else -> {
            listOf(
                LightNormal,
                Normal
            )
        }

    }
}