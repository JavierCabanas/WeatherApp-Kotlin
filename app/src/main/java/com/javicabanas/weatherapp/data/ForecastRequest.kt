package com.javicabanas.weatherapp.data

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * Created by Javi on 01/08/2015.
 */
class ForecastRequest(val zipcode: String) {

    companion object {
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?q=94043&mode=json&units=metric&cnt=7&q="
    }

    public fun execute(): ForecastResult {
        val forecastJsonStr = URL(URL+zipcode).readText()
        return Gson().fromJson(forecastJsonStr,javaClass<ForecastResult>())
    }
}

