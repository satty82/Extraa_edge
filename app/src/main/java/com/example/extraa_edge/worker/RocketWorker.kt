package com.example.extraa_edge.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.extraa_edge.RocketApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RocketWorker(val context : Context, val params : WorkerParameters,val id : String) : Worker(context,params) {
    override fun doWork(): Result {

        Log.d("RocketWorker","running")
        val repository = (context as RocketApplication).rocketRepository

        CoroutineScope(Dispatchers.IO).launch {

            repository.getRocketDetailsBackground(id)
        }

        return Result.success()
    }
}