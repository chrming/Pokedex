package com.example.pokedex.screens.pokemonList.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.model.pokemonAttributes.Type
import com.example.pokedex.screens.pokemonDetail.presentation.composables.PictureSection
import com.example.pokedex.screens.pokemonDetail.presentation.composables.StatsSection
import com.example.pokedex.screens.pokemonDetail.presentation.state.PokemonStats
import com.example.pokedex.ui.theme.*


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
    val pokemonStats = PokemonStats(
        health = pokemon.stats[0].base_stat,
        attack = pokemon.stats[1].base_stat,
        defense = pokemon.stats[2].base_stat,
        speed = pokemon.stats[5].base_stat,
    )
    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .border(1.dp, Black),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.linearGradient(colorListByType(pokemon.types[0])))
        ) {
            PictureSection(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.4f),
                pokemonName = pokemon.name,
                pokemonSpriteUrl = pokemon.sprites.other.officialArtwork?.front_default
                    ?: "None",
                pictureSize = 100.dp,
                fontSize = 25.sp
            )
            StatsSection(pokemonStats = pokemonStats, pokemonTypes = pokemon.types)
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