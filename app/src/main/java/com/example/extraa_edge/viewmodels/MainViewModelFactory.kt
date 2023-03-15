package com.example.extraa_edge.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.extraa_edge.repository.RocketRepository

class MainViewModelFactory(private val repository: RocketRepository, private val id: String): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository, id) as T
    }
}