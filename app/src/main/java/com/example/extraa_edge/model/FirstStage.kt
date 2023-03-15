package com.example.extraa_edge.model

import androidx.room.Embedded

data class FirstStage(
    val burn_time_sec: Int,
    val engines: Int,
    val fuel_amount_tons: Double,
    val reusable: Boolean,
    @Embedded(prefix = "client_1")
    val thrust_sea_level: ThrustSeaLevel,
    @Embedded(prefix = "client_2")
    val thrust_vacuum: ThrustVacuum
)