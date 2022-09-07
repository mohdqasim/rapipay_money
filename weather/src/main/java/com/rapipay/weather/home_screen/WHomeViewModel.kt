package com.rapipay.weather.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.rapipay.weather.AppDispatchers
import com.rapipay.weather.data.network.remote_source.RapipayMoneyRemoteSource
import com.rapipay.weather.data.network.api.GenerateSmsStringResponse
import com.rapipay.weather.data.network.api.WeatherViaLatLongResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class WHomeViewModel  @Inject constructor(private val remoteSource: RapipayMoneyRemoteSource, private val appDispatchers: AppDispatchers):ViewModel() {
    var state by mutableStateOf(
        WHomeContract.State())


    fun generateSmsString() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            val request = JsonObject()
            request.addProperty("mobileNumber",
                "8801254892"
            )
            var response: Response<GenerateSmsStringResponse> = remoteSource.generateSmsString(request)
           if(response.isSuccessful){
            state = state.copy(smsString = response.body()?.results?.smsString!!)
           }
            state = state.copy(isLoading = false)
        }

    }

    fun getWeatherDetails() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {

            var response: Response<WeatherViaLatLongResponse> = remoteSource.getWeatherDetails()
           if(response.isSuccessful){
            state = state.copy(weatherResponse = response.body()!!)

           }
            state = state.copy(isLoading = false)
        }

    }
}