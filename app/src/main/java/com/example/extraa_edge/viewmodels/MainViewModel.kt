package com.example.extraa_edge.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.extraa_edge.model.RocketDetailsList
import com.example.extraa_edge.model.RocketDetailsListItem
import com.example.extraa_edge.repository.RocketRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: RocketRepository, val id: String) : ViewModel() {

    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    init {
        try {

            viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
                repository.getRocketDetails()
            }
        } catch (e: Exception) {
            print(e)
        }

        //data from ID

        }

    fun callVM(id: String) {

        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {

            Log.d("viewModelScope id", "inside $id")

            repository.getRocketDetailsIDBased(id)

        }
    }

    val rocket: LiveData<RocketDetailsList>
        get() = repository.rocket

    val rocketId: LiveData<RocketDetailsListItem>
        get() = repository.rocketId


}