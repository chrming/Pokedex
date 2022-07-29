package com.example.pokedex.network.model

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)