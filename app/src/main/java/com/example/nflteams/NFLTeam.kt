package com.example.nflteams

import java.io.Serializable


data class NFLTeam(
    val teamID: String,
    val teamName: String,
    val logoFile: String,
    val conference: String,
    val division: String,
    val stadium: String,
    val latitude: Double,
    val longitude: Double
) :Serializable
