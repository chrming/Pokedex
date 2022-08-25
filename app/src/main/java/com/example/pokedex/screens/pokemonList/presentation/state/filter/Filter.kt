package com.example.pokedex.screens.pokemonList.presentation.state.filter

sealed class Filter(val filters: Array<String>) {
    object Type : Filter(
        arrayOf(
            "all",
            "fighting",
            "flying",
            "poison",
            "ground",
            "rock",
            "bug",
            "ghost",
            "steel",
            "fire",
            "water",
            "grass",
            "electric",
            "psychic",
            "ice",
            "dragon",
            "dark",
            "fairy",
            "unknown",
            "shadow"
        )
    )

    object Version : Filter(
        arrayOf(
            "all",
            "red",
            "blue",
            "yellow",
            "gold",
            "silver",
            "crystal",
            "ruby",
            "sapphire",
            "emerald",
            "firered",
            "leafgreen",
            "diamond",
            "pearl",
            "platinum",
            "heartgold",
            "soulsilver",
            "black",
            "white",
            "colosseum",
            "xd",
        )
    )
}