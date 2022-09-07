package com.example.pokedex.screens.pokemonDetail.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.datasource.model.pokemonAttributes.Attribute
import com.example.pokedex.datasource.model.pokemonAttributes.Type
import com.example.pokedex.screens.pokemonDetail.presentation.event.PokemonDetailEvent
import com.example.pokedex.screens.pokemonDetail.presentation.state.PokemonExtendedInfo
import com.example.pokedex.screens.pokemonDetail.state.ExpandedState
import com.example.pokedex.screens.pokemonList.presentation.composable.colorByType
import com.example.pokedex.screens.pokemonList.presentation.composable.colorListByType
import java.util.*

@Composable
fun SelectExtendedInfoSection(
    onClick: (PokemonDetailEvent) -> Unit,
    pokemonType: Type,
) {
    Spacer(modifier = Modifier.height(5.dp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .background(colorByType(pokemonType))
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
                InfoButton(
                    text = "Abilities",
                    colors = ButtonDefaults.buttonColors(
                        colorListByType(pokemonType)[0]
                    ),
                    onClick = { onClick(PokemonDetailEvent.Expanded.Abilities) }
                )
                InfoButton(
                    text = "Moves",
                    colors = ButtonDefaults.buttonColors(
                        colorListByType(pokemonType)[0]
                    ),
                    onClick = { onClick(PokemonDetailEvent.Expanded.Moves) }
                )
                InfoButton(
                    text = "Sprites",
                    colors = ButtonDefaults.buttonColors(
                        colorListByType(pokemonType)[0]
                    ),
                    onClick = { onClick(PokemonDetailEvent.Expanded.Sprites) }
                )
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
                InfoButton(
                    text = "Location",
                    colors = ButtonDefaults.buttonColors(
                        colorListByType(pokemonType)[0]
                    ),
                    onClick = { onClick(PokemonDetailEvent.Expanded.AreaEncounter) }
                )
                InfoButton(
                    text = "Held Items",
                    colors = ButtonDefaults.buttonColors(
                        colorListByType(pokemonType)[0]
                    ),
                    onClick = { onClick(PokemonDetailEvent.Expanded.HeldItem) }
                )
            }
        }
    }
}

@Composable
fun InfoButton(
    modifier: Modifier = Modifier,
    text: String,
    colors: ButtonColors,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier
            .padding(2.dp)
            .width(75.dp)
            .height(25.dp),
        onClick = onClick,
        border = BorderStroke(1.dp, Color.Black),
        contentPadding = PaddingValues(2.dp),
        colors = colors
    ) {
        Text(
            text = text,
            fontSize = 10.sp,
            color = Color.Black
        )
    }
}

fun LazyListScope.extendedInfoSection(
    modifier: Modifier = Modifier,
    pokemonInfo: PokemonExtendedInfo,
    expandedState: ExpandedState,
    pokemonType: Type
) {
    when (expandedState) {
        ExpandedState(abilities = true) -> {
            item {
                Row(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) { Text(text = "Abilities") }
                }
            }
            if (pokemonInfo.abilities.isNotEmpty()) {
                items(pokemonInfo.abilities) { ability ->
                    ExtendedInfoItems(
                        item = ability,
                        pokemonType = pokemonType
                    )
                }
            } else {
                item {
                    Row(Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) { Text(text = "None") }
                    }
                }
            }
        }
        ExpandedState(moves = true) -> {
            item {
                Row(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) { Text(text = "Moves") }
                }
            }
            if (pokemonInfo.moves.isNotEmpty()) {
                items(pokemonInfo.moves) { move ->
                    ExtendedInfoItems(
                        item = move,
                        pokemonType = pokemonType
                    )
                }
            } else {
                item {
                    Row(Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) { Text(text = "None") }
                    }
                }
            }
        }
        ExpandedState(sprites = true) -> {
            item {
                Row(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) { Text(text = "Sprites") }
                }
            }
            if (pokemonInfo.sprites.isNotEmpty()) {
                items(pokemonInfo.sprites) { sprite ->
                    ExtendedInfoItems(
                        item = sprite,
                        pokemonType = pokemonType
                    )
                }
            } else {
                item {
                    Row(Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) { Text(text = "None") }
                    }
                }
            }
        }
        ExpandedState(areaEncounter = true) -> {
            item {
                Row(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) { Text(text = "Locations") }
                }
            }
            if (pokemonInfo.location.isNotEmpty()) {
                items(pokemonInfo.location) { location ->
                    ExtendedInfoItems(
                        item = location,
                        pokemonType = pokemonType
                    )
                }
            } else {
                item {
                    Row(Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) { Text(text = "None") }
                    }
                }
            }
        }
        ExpandedState(heldItem = true) -> {
            item {
                Row(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) { Text(text = "Held Items") }
                }
            }
            if (pokemonInfo.heldItems.isNotEmpty()) {
                items(pokemonInfo.heldItems) { heldItem ->
                    ExtendedInfoItems(
                        item = heldItem,
                        pokemonType = pokemonType
                    )
                }
            } else {
                item {
                    Row(Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) { Text(text = "None") }
                    }
                }
            }
        }
    }
}

@Composable
fun ExtendedInfoItems(
    item: Attribute?,
    pokemonType: Type
) {
    Spacer(modifier = Modifier.height(5.dp))
    Row(Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .background(colorByType(pokemonType))
                .border(1.dp, Black),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(modifier = Modifier.padding(2.dp), text = item?.name?.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            }
                ?: "None")
        }
    }
}