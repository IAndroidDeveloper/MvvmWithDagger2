package com.mvvmwithdagger.roomdb.convert

import androidx.room.TypeConverter
import com.google.gson.Gson


/**
 * Extentia
 * PUNE.
 */

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun testsTypesToString(testTypes:List<String>):String=gson.toJson(testTypes)
    @TypeConverter
    fun stringToTestsType(testTypes:String):List<String> =gson.fromJson(testTypes,Array<String>::class.java).toList()
}