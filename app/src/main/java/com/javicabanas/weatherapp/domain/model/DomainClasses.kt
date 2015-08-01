package com.javicabanas.weatherapp.domain.model

/**
 * Created by Javi on 01/08/2015.
 */

data class ForecastList(val city: String, val country:String,
                    val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int)