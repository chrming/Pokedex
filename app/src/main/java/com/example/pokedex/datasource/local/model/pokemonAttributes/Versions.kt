package com.example.pokedex.datasource.local.model.pokemonAttributes

import androidx.room.Embedded

data class Versions(
    @Embedded
    val generationI: GenerationI,
    @Embedded
    val generationII: GenerationII,
    @Embedded
    val generationIII: GenerationIII,
    @Embedded
    val generationIV: GenerationIV,
    @Embedded
    val generationV: GenerationV,
    @Embedded
    val generationVI: GenerationVI,
    @Embedded
    val generationVII: GenerationVII,
    @Embedded
    val generationVIII: GenerationVIII
)