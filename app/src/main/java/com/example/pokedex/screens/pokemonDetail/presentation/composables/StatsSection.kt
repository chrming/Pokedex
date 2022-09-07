package com.example.pokedex.screens.pokemonDetail.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.model.pokemonAttributes.Type
import com.example.pokedex.screens.pokemonDetail.presentation.state.PokemonStats
import com.example.pokedex.screens.pokemonList.presentation.composable.colorByType
import com.example.pokedex.screens.pokemonList.presentation.composable.colorListByType
import com.example.pokedex.ui.theme.Attack
import com.example.pokedex.ui.theme.Defense
import com.example.pokedex.ui.theme.Health
import com.example.pokedex.ui.theme.Speed
import java.util.*

@Composable
fun StatsSection(pokemonStats: PokemonStats, pokemonTypes: List<Type>) {

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
                    .background(colorByType(pokemonTypes[0]))
                    .border(1.dp, Color.Black),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {
                Stat(
                    title = "HP",
                    stat = pokemonStats.health,
                    statMax = Pokemon.maxHp,
                    progressBarColor = Health
                )
                Stat(
                    title = "ATK",
                    stat = pokemonStats.attack,
                    statMax = Pokemon.maxAttack,
                    progressBarColor = Attack
                )
                Stat(
                    title = "DEF",
                    stat = pokemonStats.defense,
                    statMax = Pokemon.maxDefense,
                    progressBarColor = Defense
                )
                Stat(
                    title = "SPD",
                    stat = pokemonStats.speed,
                    statMax = Pokemon.maxSpeed,
                    progressBarColor = Speed
                )
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
                        fontSize = 15.sp
                    )
                    Row() {
                        pokemonTypes.forEach {
                            TextButton(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .width(50.dp)
                                    .height(20.dp),
                                onClick = {/*TODO filter by this chip*/ },
                                border = BorderStroke(1.dp, Color.Black),
                                contentPadding = PaddingValues(2.dp),
                                colors = ButtonDefaults.buttonColors(colorListByType(it)[0])
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

        }
    }
}

@Composable
fun Stat(title: String, stat: Int, statMax: Int, progressBarColor: Color) {
    Row(
        modifier = Modifier
            .width(400.dp)
            .padding(horizontal = 10.dp)
            .padding(top = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 15.sp
        )
        Box(contentAlignment = Alignment.CenterStart) {
            LinearProgressIndicator(
                modifier = Modifier
                    .height(15.dp)
                    .border(1.dp, Color.Black)
                    .shadow(5.dp),
                progress = stat.toFloat() / statMax.toFloat(),
                color = progressBarColor
            )
            Text(
                modifier = Modifier.padding(start = 2.dp),
                text = "$stat / $statMax",
                fontSize = 12.sp,
                color = Color.Black
            )
        }
    }
}