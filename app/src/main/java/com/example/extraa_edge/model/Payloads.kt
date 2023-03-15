package com.example.extraa_edge.model

import androidx.room.Embedded

data class Payloads(
    @Embedded(prefix = "c1")
    val composite_fairing: CompositeFairing,
    val option_1: String
)