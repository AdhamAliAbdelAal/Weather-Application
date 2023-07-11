package com.example.loginapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.weather_item.view.imgWeather
import kotlinx.android.synthetic.main.weather_item.view.tvCondition
import kotlinx.android.synthetic.main.weather_item.view.tvDate

class WeatherAdaptor(val days:List<Day>): RecyclerView.Adapter<WeatherAdaptor.WeatherViewHolder>() {
    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        // the purpose of this function is to create the view holder
        // create the view
        // create the view holder
        // return the view holder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
        // the layout inflater is used to inflate the layout
        // inflate means to create the view from the layout
        // parent is the view group
        // false means we don't want to attach the view to the parent
        // we will attach it later
        return WeatherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return days.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        // the purpose of this function is to bind the data to the view holder
        // take the data from the list and bind it to the view holder
        // holder is the view holder
        // position is the position of the item in the list
        holder.itemView.apply {
            tvCondition.text = days[position].condition
            tvDate.text = days[position].date
            imgWeather.setImageResource(days[position].image)
        }
    }

}