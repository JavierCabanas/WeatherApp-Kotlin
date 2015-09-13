package com.javicabanas.weatherapp.domain.commands

/**
 * Created by Javi on 01/08/2015.
 */
interface Command<T> {
    fun execute():T
}