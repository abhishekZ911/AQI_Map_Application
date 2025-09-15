package com.abhishek.aqi_mapapplication.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RecentDataNew(
    @SerializedName("aqi_ind") val aqiInd: Int,
    @SerializedName("aqi_us") val aqiUs: Int,
    @SerializedName("battery") val battery: Int,
    @SerializedName("co") val co: Double,
    @SerializedName("no2") val no2: Double,
    @SerializedName("pm10") val pm10: Double,
    @SerializedName("pm25") val pm25: Double,
    @SerializedName("so2") val so2: Double
)
