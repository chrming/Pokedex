package com.example.pokedex.screens.pokemonList.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.size.Dimension
import com.example.pokedex.datasource.local.model.pokemonAttributes.Attribute

@Preview
@Composable
fun PreviewPokemonListItem() {
    PokemonListItem(
        spriteUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/24.png",
        name = "Arbok",
        type = Attribute("poison", "https://pokeapi.co/api/v2/type/4/")
    ) {}
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonListItem(
    modifier: Modifier = Modifier,
    spriteUrl: String,
    name: String,
    type: Attribute,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.size(Dimension.Pixels(120).px.dp),
        backgroundColor = backgroundColorByType(type.name),
        onClick = onClick
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SubcomposeAsyncImage(
                model = spriteUrl,
                contentDescription = null,
                loading = {
                    CircularProgressIndicator()
                }
            )
            Text(text = name)
        }
    }
}

fun backgroundColorByType(pokemonType: String): Color {
    val backgroundColor: Color = when (pokemonType) {
        "fighting" -> {
            Color(113, 53, 50)
            //Color(94, 44, 42)
        }
        "flying" -> {
            Color(38, 26, 76)//, rgb(66, 59, 90))
        }
        "poison" -> {
            Color(104, 64, 104)//, rgb(85, 53, 85))
        }
        "ground" -> {
            Color(92, 82, 51)//, rgb(114, 101, 62))
        }
        "rock" -> {
            Color(137, 127, 84)//, rgb(111, 103, 68))
        }
        "bug" -> {
            Color(134, 141, 78)//, rgb(114, 119, 66))
        }
        "ghost" -> {
            Color(87, 76, 103)//, rgb(67, 60, 81))
        }
        "steel" -> {
            Color(54, 54, 66)//, rgb(66, 66, 82))
        }
        "fire" -> {
            Color(136, 88, 53)//, rgb(140, 91, 55))
        }
        "water" -> {
            Color(34, 53, 99)//, rgb(40, 63, 118))
        }
        "grass" -> {
            Color(110, 136, 84)// rgb(94, 126, 78))
        }
        "electric" -> {
            Color(118, 105, 53)//, rgb(171, 152, 74))
        }
        "psychic" -> {
            Color(101, 26, 49)//, rgb(124, 31, 59))
        }
        "ice" -> {
            Color(62, 95, 95)//, rgb(79, 120, 120))
        }
        "dragon" -> {
            Color(46, 21, 107)//, rgb(52, 23, 119))
        }
        "dark" -> {
            Color(85, 74, 68)//, rgb(63, 55, 51));
        }
        "fairy" -> {
            Color(80, 38, 80)//, rgb(98, 46, 98))
        }
        "unknown" -> {
            Color(85, 85, 70) //rgb(110, 110, 89))
        }
        "shadow" -> {
            Color(85, 85, 70) //rgb(110, 110, 89))
        }
        else -> {
            Color(85, 85, 70) //rgb(110, 110, 89))
        }
    }
    return backgroundColor
}

