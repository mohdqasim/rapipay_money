package com.rapipay.weather.data.network.remote_source

import com.google.gson.JsonObject
import com.rapipay.weather.data.network.api.GenerateSmsStringResponse
import com.rapipay.weather.data.network.api.WeatherViaLatLongResponse
import com.rapipay.weather.data.network.remote_source.RapipayMoneyBankApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RapipayMoneyRemoteSource @Inject constructor(private val neoBankApi: RapipayMoneyBankApi) {

    suspend fun generateSmsString(request: JsonObject): Response<GenerateSmsStringResponse> = withContext(Dispatchers.IO) {
        neoBankApi.generateSmsString(request)
    }
    suspend fun getWeatherDetails(): Response<WeatherViaLatLongResponse> = withContext(Dispatchers.IO) {
        neoBankApi.getWeatherDetails()
    }
}
