package com.example.pokedex.datasource

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@ProvidedTypeConverter
class AttributesTypeConverter {

    @TypeConverter
    fun <T> toString(data: List<T>):String {
        val gson = Gson()
        return gson.toJson(data)

    }

    @TypeConverter
    fun <T> toTypeT(data: String): T{
        val listType: Type = object : TypeToken<List<T>>() {}.type
        return Gson().fromJson(data, listType)
    }
}