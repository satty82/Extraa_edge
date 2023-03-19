package com.example.extraa_edge

import android.app.Application
import androidx.constraintlayout.widget.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.extraa_edge.api.RetrofitHelper
import com.example.extraa_edge.api.RocketDetailsService
import com.example.extraa_edge.db.RocketDatabase
import com.example.extraa_edge.repository.RocketRepository
import com.example.extraa_edge.worker.RocketWorker
import java.util.concurrent.TimeUnit

class RocketApplication : Application() {

    lateinit var rocketRepository: RocketRepository

    override fun onCreate() {
        super.onCreate()

        initialize()
        setUpWorker()
    }

    private fun setUpWorker() {

        val constraint = androidx.work.Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
        val workRequest = PeriodicWorkRequest.Builder(RocketWorker::class.java,15,TimeUnit.MINUTES)
            .setConstraints(constraints = constraint.build())
            .build()

        WorkManager.getInstance(this).enqueue(workRequest)
    }

    private fun initialize() {

        val rocketService = RetrofitHelper.getInstance().create(RocketDetailsService::class.java)
        val database = RocketDatabase.getDatabase(applicationContext)

        rocketRepository = RocketRepository(rocketService) // pass database as argument for RoomDB

    }
}