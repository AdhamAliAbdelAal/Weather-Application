package com.example.loginapp

data class Forecastday(
    val astro: Astro,
    val date: String,
    val date_epoch: Int,
    val day: DayX,
    val hour: List<Hour>
)