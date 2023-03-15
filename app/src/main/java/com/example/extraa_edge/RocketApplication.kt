package com.example.extraa_edge

import android.app.Application
import com.example.extraa_edge.api.RetrofitHelper
import com.example.extraa_edge.api.RocketDetailsService
import com.example.extraa_edge.db.RocketDatabase
import com.example.extraa_edge.repository.RocketRepository

class RocketApplication : Application() {

    lateinit var rocketRepository: RocketRepository


    override fun onCreate() {
        super.onCreate()

        initialize()
    }

    private fun initialize() {

        val rocketService = RetrofitHelper.getInstance().create(RocketDetailsService::class.java)
        val database = RocketDatabase.getDatabase(applicationContext)

        rocketRepository = RocketRepository(rocketService) // pass database as argument for RoomDB

    }
}