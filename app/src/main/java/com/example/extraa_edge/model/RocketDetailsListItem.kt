package com.example.extraa_edge.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rocket")
data class RocketDetailsListItem(
    @PrimaryKey(autoGenerate = true)
    val rocketId : Int?,
    val active: Boolean,
    val boosters: Int,
    val company: String,
    val cost_per_launch: Int,
    val country: String,
    val description: String,
    @Embedded(prefix = "rd1")
    val diameter: Diameter,
    @Embedded(prefix = "rd2")
    val engines: Engines,
    val first_flight: String,
    @Embedded(prefix = "rd3")
    val first_stage: FirstStage,
    @Embedded(prefix = "rd4")
    val flickr_images: ArrayList<String>,
    @Embedded(prefix = "rd5")
    val height: Height,
    val id: String,
    @Embedded(prefix = "rd6")
    val landing_legs: LandingLegs,
    @Embedded(prefix = "rd7")
    val mass: Mass,
    val name: String,
    @Embedded(prefix = "rd8")
    val payload_weights: List<PayloadWeight>,
    @Embedded(prefix = "rd9")
    val second_stage: SecondStage,
    val stages: Int,
    val success_rate_pct: Int,
    val type: String,
    val wikipedia: String
)