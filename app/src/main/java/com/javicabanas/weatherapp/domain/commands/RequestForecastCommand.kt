package com.javicabanas.weatherapp.domain.commands

import com.javicabanas.weatherapp.data.ForecastRequest
import com.javicabanas.weatherapp.domain.mappers.ForecastDataMapper
import com.javicabanas.weatherapp.domain.model.ForecastList

/**
 * Created by Javi on 01/08/2015.
 */
class RequestForecastCommand(private val zipCode:String) : Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest= ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}