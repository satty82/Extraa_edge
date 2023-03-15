package com.example.extraa_edge.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.extraa_edge.model.RocketDetailsListItem

//@Database(entities = [RocketDetailsListItem::class], version = 1)
abstract class RocketDatabase : RoomDatabase() {

    abstract fun rocketDao(): RocketDao

    companion object {

        @Volatile
        private var INSTANCE: RocketDatabase? = null

        fun getDatabase(context: Context): RocketDatabase {

            if (INSTANCE == null) {

                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        RocketDatabase::class.java, "rocketDB"
                    ).build()
                }

            }
                return INSTANCE!!
        }


    }

}