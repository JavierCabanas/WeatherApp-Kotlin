package com.javicabanas.weatherapp.extensions

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Javi on 14/11/2015.
 */

object DelegateExt {
    fun <T> notNullSingleValue():
        kotlin.properties.ReadWriteProperty<Any?, T> =NotNullSingleValueVar()
}

private class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }
}