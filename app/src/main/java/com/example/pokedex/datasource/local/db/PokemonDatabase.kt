package com.example.pokedex.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pokedex.datasource.local.typeConverter.AttributesTypeConverter
import com.example.pokedex.datasource.local.model.Pokemon

@Database(entities = [Pokemon::class], version = 1)
@TypeConverters(AttributesTypeConverter::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao

    companion object {
        const val DATABASE_NAME = "pokemon_db"
    }
}