package com.example.extraa_edge.model

import androidx.room.Embedded

data class SecondStage(
    val burn_time_sec: Int,
    val engines: Int,
    val fuel_amount_tons: Double,
    @Embedded(prefix = "ss1")
    val payloads: Payloads,
    val reusable: Boolean,
    @Embedded(prefix = "ss2")
    val thrust: Thrust
)