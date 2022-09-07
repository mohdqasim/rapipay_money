package com.rapipay.weather.data.network.api

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface WeatherApiService {

   @POST("/auth/api/v1/mobile/sign_up/generate_sms_string")
   suspend fun generateSmsString(@Body request: JsonObject): Response<GenerateSmsStringResponse>


   @GET("/data/2.5/weather?lat=17.385044&lon=78.486671&appid=ad6a670b4d2aaa874cc01b55fd3b9bce")
   suspend fun getWeatherDetails(): Response<WeatherViaLatLongResponse>


   }


