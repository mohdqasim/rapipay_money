package com.rapipay.weather.data.network.remote_source

import com.google.gson.JsonObject
import com.rapipay.weather.data.network.api.GenerateSmsStringResponse
import com.rapipay.weather.data.network.api.WeatherApiService
import com.rapipay.weather.data.network.api.WeatherViaLatLongResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class RapipayMoneyBankApi @Inject constructor(
    private val weatherApiService: WeatherApiService,
) {

    suspend fun generateSmsString(request: JsonObject): Response<GenerateSmsStringResponse> =
        weatherApiService.generateSmsString(request)

    suspend fun getWeatherDetails(): Response<WeatherViaLatLongResponse> =
        weatherApiService.getWeatherDetails()
}