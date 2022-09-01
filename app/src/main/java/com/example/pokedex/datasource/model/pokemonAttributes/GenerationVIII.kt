package com.example.pokedex.datasource.model.pokemonAttributes

import androidx.room.Embedded

data class GenerationVIII(
    @Embedded(prefix = "genviii_icons_")
    val icons: Icons?
){
    constructor(): this(Icons())
}