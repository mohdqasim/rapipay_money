package com.rapipay.weather.home_screen

import com.rapipay.weather.data.network.api.WeatherViaLatLongResponse

class WHomeContract {
    data class State(
        val isLoading:Boolean = false,
        val smsString:String = "",
        val weatherResponse:WeatherViaLatLongResponse = WeatherViaLatLongResponse(),
    )
}