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
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater) // binding variable
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // binding variable
        val view = binding.root
        setContentView(view)
//        val days = mutableListOf<Day>(
//            Day("Sunny", R.drawable.img, "2023-07-10 04:00"),
//            Day("Rainy", R.drawable.img, "2023-07-11 00:00"),
//            Day("Cloudy", R.drawable.img, "2023-07-12 07:00"),
//            Day("Sunny", R.drawable.img, "2023-07-13 09:00"),
//            Day("Rainy", R.drawable.img, "2023-07-14 08:00"),
//            Day("Cloudy", R.drawable.img, "2023-07-15 06:00"),
//            Day("Sunny", R.drawable.img, "2023-07-16 02:00"),
//            Day("Sunny", R.drawable.img, "2023-07-16 02:00"),
//            Day("Sunny", R.drawable.img, "2023-07-16 02:00"),
//            Day("Sunny", R.drawable.img, "2023-07-16 02:00"),
//            Day("Sunny", R.drawable.img, "2023-07-16 02:00")
//        )
//        val adapter = WeatherAdaptor(days)
//        binding.rvWeather.adapter = adapter
//        binding.rvWeather.layoutManager = LinearLayoutManager(this)
        fetchData()
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
//                val responseBody = response.body()
                Log.i("Response", "Done")
            }

            override fun onFailure(call: Call<Forecast?>, t: Throwable) {
                Log.i("Response", t.toString())
            }
        })
    }
}