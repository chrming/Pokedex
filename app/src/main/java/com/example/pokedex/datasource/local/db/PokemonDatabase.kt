package com.example.pokedex.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pokedex.datasource.local.db.dao.PokemonDao
import com.example.pokedex.datasource.local.db.dao.PokemonRemoteKeyDao
import com.example.pokedex.datasource.local.db.dao.PokemonUiItemDao
import com.example.pokedex.datasource.local.typeConverter.AttributesTypeConverter
import com.example.pokedex.datasource.model.Pokemon
import com.example.pokedex.datasource.model.PokemonRemoteKeys
import com.example.pokedex.datasource.model.PokemonUiItem

@Database(entities = [Pokemon::class, PokemonUiItem::class, PokemonRemoteKeys::class], version = 1)
@TypeConverters(AttributesTypeConverter::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonUiItemDao(): PokemonUiItemDao
    abstract fun pokemonRemoteKeyDao(): PokemonRemoteKeyDao
}