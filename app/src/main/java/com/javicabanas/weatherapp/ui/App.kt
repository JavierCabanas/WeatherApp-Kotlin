package com.javicabanas.weatherapp.ui

import android.app.Application
import com.javicabanas.weatherapp.extensions.DelegateExt
import kotlin.properties.Delegates

/**
 * Created by Javi on 24/01/2016.
 */
class App : Application(){

    companion object {
        var instance: App by DelegateExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }
}