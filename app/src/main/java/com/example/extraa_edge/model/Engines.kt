package com.example.extraa_edge.model

import androidx.room.Embedded


data class Engines(
    val engine_loss_max: Int,
    @Embedded(prefix = "client1")
    val isp: Isp,
    val layout: String,
    val number: Int,
    val propellant_1: String,
    val propellant_2: String,
    @Embedded(prefix = "client2")
    val thrust_sea_level: ThrustSeaLevel,
    val thrust_to_weight: Double,
    @Embedded(prefix = "client3")
    val thrust_vacuum: ThrustVacuum,
    val type: String,
    val version: String
)