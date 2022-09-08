package com.example.pokedex.screens.pokemonDetail.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedex.ui.theme.PokemonTypography
import java.util.*

@Composable
fun PictureSection(
    modifier: Modifier = Modifier,
    pokemonName: String,
    pokemonSpriteUrl: String,
    pictureSize: Dp,
    fontSize: TextUnit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier.size(pictureSize),
            model = ImageRequest.Builder(LocalContext.current)
                .data(pokemonSpriteUrl)
                .crossfade(600)
                .build(),
            contentDescription = null,
        )
        Box(modifier = Modifier,) {
            Text(
                modifier = Modifier,
                text = pokemonName.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                },
                style = PokemonTypography.body1,
                color = Color.White,
                letterSpacing = 1.sp,
                fontSize = fontSize
            )
            Text(
                modifier = Modifier,
                text = pokemonName.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                },
                style = PokemonTypography.h1,
                color = Color.Black,
                letterSpacing = 1.sp,
                fontSize = fontSize
            )
        }
    }
}