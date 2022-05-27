package com.fiz.starwarsinformer.common.data.local.database

import androidx.room.TypeConverter

object StringListConverter {

    @TypeConverter
    fun stringListToString(list: MutableList<String>?): String? =
            list?.joinToString(separator = "|")

    @TypeConverter
    fun stringToStringList(string: String?): MutableList<String>? =
            string?.split("|")?.toMutableList()
}