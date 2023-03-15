package com.example.extraa_edge.model

import androidx.room.Embedded

data class CompositeFairing(
    @Embedded(prefix = "c1")
    val diameter: Diameter,
    @Embedded(prefix = "c2")
    val height: Height
)