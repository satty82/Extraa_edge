package com.example.extraa_edge.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.extraa_edge.api.RocketDetailsService
import com.example.extraa_edge.db.RocketDatabase
import com.example.extraa_edge.model.RocketDetailsList
import com.example.extraa_edge.model.RocketDetailsListItem

class RocketRepository(private val rocketDetailsService: RocketDetailsService, private val rocketDatabase: RocketDatabase ) {

    private val rocketLiveData = MutableLiveData<RocketDetailsList>()
    private val rocketLiveDataID = MutableLiveData<RocketDetailsListItem>()


    val rocket: LiveData<RocketDetailsList>
        get() = rocketLiveData

    val rocketId: LiveData<RocketDetailsListItem>
        get() = rocketLiveDataID

    suspend fun getRocketDetails() {

        val result = rocketDetailsService.getRecketDetails()

        if (result.body() != null) {

            rocketLiveData.postValue(result.body())

        }
    }


    suspend fun getRocketDetailsIDBased(id: String) {

        val result = rocketDetailsService.getRocketDetailsonID(id)
        Log.d("getRocketDetails", "inside $id")

        if (result.body() != null) {

            rocketLiveDataID.postValue(result.body())
            rocketDatabase.rocketDao().addRocket(result.body())


            Log.d("getRocket result", "inside ${result.body()}")

        }

    }


}