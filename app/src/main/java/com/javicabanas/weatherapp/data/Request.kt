package com.javicabanas.weatherapp.data

import android.util.Log
import java.net.URL

/**
 * Created by Javi on 01/08/2015.
 */
public class Request (val url: String){
    public fun run(){
        val forecastJsonStr= URL(url).readText()
        Log.d(javaClass.getSimpleName(),forecastJsonStr)
    }
}

