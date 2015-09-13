package com.javicabanas.weatherapp.domain.mappers

import com.javicabanas.weatherapp.data.Forecast
import com.javicabanas.weatherapp.data.ForecastResult
import com.javicabanas.weatherapp.domain.model
import com.javicabanas.weatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.Locale

/**
 * Created by Javi on 01/08/2015.
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<model.Forecast> {
        return list map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): model.Forecast {
        return model.Forecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}