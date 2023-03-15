package com.example.extraa_edge.api

import com.example.extraa_edge.model.RocketDetailsList
import com.example.extraa_edge.model.RocketDetailsListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RocketDetailsService {

    @GET("rockets")
    suspend fun getRecketDetails() : Response<RocketDetailsList>


    @GET("rockets/{id}")
    suspend fun getRocketDetailsonID(@Path("id") id:String) : Response<RocketDetailsListItem>
}