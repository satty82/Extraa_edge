package com.example.extraa_edge.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.extraa_edge.model.RocketDetailsListItem

@Dao
interface RocketDao {

    @Insert
    suspend fun addRocket(rocket: RocketDetailsListItem?)

    @Query("SELECT * FROM rocket" )
    suspend fun getRocket()
}