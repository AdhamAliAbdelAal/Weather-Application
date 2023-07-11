package com.example.loginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.example.loginapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding // binding variable
    private val BASE_URL = "https://api.weatherapi.com/v1/"
    val days = mutableListOf<Day>()
    lateinit var adaptor: WeatherAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater) // binding variable
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // binding variable
        val view = binding.root
        setContentView(view)
        fetchData()
        adaptor = WeatherAdaptor(days)
        binding.rvWeather.adapter = adaptor
        binding.rvWeather.layoutManager = LinearLayoutManager(this)
    }
    private fun fetchData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<Forecast?> {
            override fun onResponse(call: Call<Forecast?>, response: Response<Forecast?>) {
                val responseBody = response.body()
                Log.i("Response", responseBody.toString())
                val forecast = responseBody?.forecast
                val forecastDays = forecast?.forecastday
                for (day in forecastDays!!) {
                    val date = day.date
                    val condition = day.day.condition.text
                    val image = R.drawable.img
                    val day = Day(condition, image, date)
                    days.add(day)
                }
                adaptor.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<Forecast?>, t: Throwable) {
                Log.i("Response", t.toString())
            }
        })
    }
}