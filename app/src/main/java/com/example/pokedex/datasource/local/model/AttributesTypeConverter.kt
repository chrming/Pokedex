package com.example.pokedex.datasource.local.model

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.pokedex.datasource.network.model.pokemonAttributes.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@ProvidedTypeConverter
class AttributesTypeConverter {

    // Type converter for Stat
    @TypeConverter
    fun statToString(data: List<Stat>): String {
        val gson = Gson()
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToStat(data: String): List<Stat> {
        val listType: Type = object : TypeToken<List<Stat>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for PastType
    @TypeConverter
    fun pastTypeToString(data: List<PastType>): String {
        val gson = Gson()
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToPastType(data: String): List<PastType> {
        val listType: Type = object : TypeToken<List<PastType>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for Move
    @TypeConverter
    fun moveToString(data: List<Move>): String {
        val gson = Gson()
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToMove(data: String): List<Move> {
        val listType: Type = object : TypeToken<List<Move>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for VersionGroupDetail
    @TypeConverter
    fun versionGroupDetailToString(data: List<VersionGroupDetail>): String {
        val gson = Gson()
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToVersionGroupDetail(data: String): List<VersionGroupDetail> {
        val listType: Type = object : TypeToken<List<VersionGroupDetail>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for HeldItem
    @TypeConverter
    fun heldItemToString(data: List<HeldItem>): String {
        val gson = Gson()
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToHeldItem(data: String): List<HeldItem> {
        val listType: Type = object : TypeToken<List<HeldItem>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for VersionDetail
    @TypeConverter
    fun versionDetailToString(data: List<VersionDetail>): String {
        val gson = Gson()
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToVersionDetail(data: String): List<VersionDetail> {
        val listType: Type = object : TypeToken<List<VersionDetail>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for GameIndice
    @TypeConverter
    fun gameIndiceToString(data: List<GameIndice>): String {
        val gson = Gson()
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToGameIndice(data: String): List<GameIndice> {
        val listType: Type = object : TypeToken<List<GameIndice>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for Attribute
    @TypeConverter
    fun attributeToString(data: List<Attribute>): String {
        val gson = Gson()
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToAttribute(data: String): List<Attribute> {
        val listType: Type = object : TypeToken<List<Attribute>>() {}.type
        return Gson().fromJson(data, listType)
    }
}