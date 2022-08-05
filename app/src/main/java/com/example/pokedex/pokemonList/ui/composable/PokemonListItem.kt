package com.example.pokedex.pokemonList.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedex.datasource.local.model.pokemonAttributes.Attribute

@Composable
fun PokemonListItem(modifier: Modifier = Modifier, spriteUrl: String, name: String, type: Attribute) {
    Card(
        modifier = modifier,
        backgroundColor = backgroundColor(type)
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(spriteUrl)
                    .build(),
                contentDescription = "Image of $name",

                )
            Text(text = name)
        }
    }
}

fun backgroundColor(pokemonType: Attribute): Color {
    val backgroundColor: Color = when (pokemonType.name) {
        "fighting" -> {
            Color(113, 53, 50) //rgb(94, 44, 42))
        }
        "flying" -> {
            Color(38, 26, 76)//, rgb(66, 59, 90))
        }
        "poison" -> {
            Color(226, 225, 223)//, rgb(85, 53, 85))
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

