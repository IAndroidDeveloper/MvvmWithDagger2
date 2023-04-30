package com.mvvmwithdagger.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mvvmwithdagger.roomdb.convert.Converters
import com.mvvmwithdagger.roomdb.dao.MvvmWithDaggerDao
import com.mvvmwithdagger.roomdb.model.Model

/**
 * Akash.Singh
 * MOHALI.
 */
@Database(
    entities = [Model::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class MvvmWithDaggerDB : RoomDatabase() {
    abstract fun mfDao(): MvvmWithDaggerDao

    companion object {
        var TAG: String = MvvmWithDaggerDB::class.java.name

        @Volatile
        private var INSTANCE: MvvmWithDaggerDB? = null

        fun getDatabase(context: Context): MvvmWithDaggerDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MvvmWithDaggerDB::class.java,
                    "MvvmWithDagger.db"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}