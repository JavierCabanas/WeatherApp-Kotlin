package com.javicabanas.weatherapp.data.db

/**
 * Created by Javi on 24/01/2016.
 */

object CityForecastTable {
    val NAME="CityForecast"
    val ID = "_id"
    val CITY = "city"
    val COUNTRY = "country"
}

object DayForecastTable {
    val NAME="CityForecast"
    val ID = "_id"
    val DATE = "date"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val ICON_URL = "iconUrl"
    val CITY_ID= "cityId"
}