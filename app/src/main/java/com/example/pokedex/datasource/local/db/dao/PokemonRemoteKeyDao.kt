package com.example.pokedex.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.datasource.model.PokemonRemoteKeys

@Dao
interface PokemonRemoteKeyDao {

    @Query("SELECT * FROM pokemon_remote_keys_table WHERE id =:id")
    suspend fun getRemoteKeys(id: String): PokemonRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<PokemonRemoteKeys>)

    @Query("DELETE FROM pokemon_remote_keys_table")
    suspend fun deleteAllRemoteKeys()

}