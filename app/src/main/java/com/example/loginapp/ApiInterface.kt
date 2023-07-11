package com.example.loginapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("forecast.json?key=883918252aba4a38b06210624231007&q=London&aqi=no&days=14")
    fun getData(): Call<Forecast>
}