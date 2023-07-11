package com.example.loginapp

data class Forecast(
    val current: Current,
    val forecast: ForecastX,
    val location: Location
)