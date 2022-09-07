package com.rapipay.weather.data.network.api

import com.google.gson.annotations.SerializedName
data class GenerateSmsStringResponse(
    @SerializedName("message") var message: String? = null,
    @SerializedName("results") var results: Results? = null,
)
data class Results(
    @SerializedName("smsString") val smsString: String,
    @SerializedName("sendToMobileNumber") val sendToMobileNumber: String,
    @SerializedName("secretKey") val secretKey: String
)


data class WeatherViaLatLongResponse (

    @SerializedName("weather"    ) var weather    : ArrayList<Weather> = arrayListOf(),
    @SerializedName("main"       ) var main       : Main?              = Main(),
    @SerializedName("base"       ) var base       : String?            = null,
    @SerializedName("visibility" ) var visibility : Int?               = null,
    @SerializedName("dt"         ) var dt         : Int?               = null,
    @SerializedName("timezone"   ) var timezone   : Int?               = null,
    @SerializedName("id"         ) var id         : Int?               = null,
    @SerializedName("name"       ) var name       : String?            = null,
    @SerializedName("cod"        ) var cod        : Int?               = null

)

data class Weather (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("main"        ) var main        : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("icon"        ) var icon        : String? = null

)


data class Main (

    @SerializedName("temp"       ) var temp      : Double? = null,
    @SerializedName("feels_like" ) var feelsLike : Double? = null,
    @SerializedName("temp_min"   ) var tempMin   : Double? = null,
    @SerializedName("temp_max"   ) var tempMax   : Double? = null,
    @SerializedName("pressure"   ) var pressure  : Int?    = null,
    @SerializedName("humidity"   ) var humidity  : Int?    = null

)