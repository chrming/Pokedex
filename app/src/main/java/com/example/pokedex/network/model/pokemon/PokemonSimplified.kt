package com.example.pokedex.network.model.pokemon

import com.example.pokedex.network.model.Sprites
import com.example.pokedex.network.model.Type
import com.google.gson.annotations.SerializedName

data class PokemonSimplified(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)