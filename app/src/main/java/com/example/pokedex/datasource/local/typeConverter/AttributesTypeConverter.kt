package com.example.pokedex.datasource.local.typeConverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.pokedex.datasource.model.pokemonAttributes.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class AttributesTypeConverter {

    val gson = Gson()

    /*
    // Type converter for Any
    @TypeConverter
    fun anyToString(data: Any): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToAny(data: String): Any {
        val anyType = object : TypeToken<Any>() {}.type
        return gson.fromJson(data, anyType)
    }
*/

    // Type converter for Type
    @TypeConverter
    fun typeToString(data: List<Type>): String {
        return Gson().toJson(data)
    }

    @TypeConverter
    fun stringToType(data: String): List<Type> {
        val listType = object : TypeToken<List<Type>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for Ability
    @TypeConverter
    fun abilityToString(data: List<Ability>): String {
        return Gson().toJson(data)
    }

    @TypeConverter
    fun stringToAbility(data: String): List<Ability> {
        val listType = object : TypeToken<List<Ability>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for Stat
    @TypeConverter
    fun statToString(data: List<Stat>): String {
        return Gson().toJson(data)
    }

    @TypeConverter
    fun stringToStat(data: String): List<Stat> {
        val listType = object : TypeToken<List<Stat>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for PastType
    @TypeConverter
    fun pastTypeToString(data: List<PastType>): String {
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToPastType(data: String): List<PastType> {
        val listType = object : TypeToken<List<PastType>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for Move
    @TypeConverter
    fun moveToString(data: List<Move>): String {
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToMove(data: String): List<Move> {
        val listType = object : TypeToken<List<Move>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for VersionGroupDetail
    @TypeConverter
    fun versionGroupDetailToString(data: List<VersionGroupDetail>): String {
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToVersionGroupDetail(data: String): List<VersionGroupDetail> {
        val listType = object : TypeToken<List<VersionGroupDetail>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for HeldItem
    @TypeConverter
    fun heldItemToString(data: List<HeldItem>): String {
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToHeldItem(data: String): List<HeldItem> {
        val listType = object : TypeToken<List<HeldItem>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for VersionDetail
    @TypeConverter
    fun versionDetailToString(data: List<VersionDetail>): String {
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToVersionDetail(data: String): List<VersionDetail> {
        val listType = object : TypeToken<List<VersionDetail>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for GameIndice
    @TypeConverter
    fun gameIndiceToString(data: List<GameIndice>): String {
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToGameIndice(data: String): List<GameIndice> {
        val listType = object : TypeToken<List<GameIndice>>() {}.type
        return Gson().fromJson(data, listType)
    }

    // Type converter for Attribute
    @TypeConverter
    fun attributeToString(data: List<Attribute>): String {
        return gson.toJson(data)

    }

    @TypeConverter
    fun stringToAttribute(data: String): List<Attribute> {
        val listType = object : TypeToken<List<Attribute>>() {}.type
        return Gson().fromJson(data, listType)
    }
}