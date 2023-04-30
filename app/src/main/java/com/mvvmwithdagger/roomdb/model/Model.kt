package com.mvvmwithdagger.roomdb.model

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Keep
@Entity(tableName = "AirParts")
data class Model(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long?,
    @ColumnInfo( name = "userName")
    var userName: String?,
    @ColumnInfo( name = "password")
    var password: String?,

): Serializable


