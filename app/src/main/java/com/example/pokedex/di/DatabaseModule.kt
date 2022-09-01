package com.example.pokedex.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.pokedex.const.Constants.POKEMON_DATABASE
import com.example.pokedex.datasource.local.db.PokemonDatabase
import com.example.pokedex.datasource.local.typeConverter.AttributesTypeConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providePokemonDatabase(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(
            context,
            PokemonDatabase::class.java,
            POKEMON_DATABASE
        ).addTypeConverter(AttributesTypeConverter())
            .build()
    }
}