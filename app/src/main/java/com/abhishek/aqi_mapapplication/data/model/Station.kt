package com.abhishek.aqi_mapapplication.data.model

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Station(
    @SerializedName("city_name") val cityName: String,
    @SerializedName("country_name") val countryName: String,
    @SerializedName("device_name") val deviceName: String,
    @SerializedName("device_uid") val deviceUid: String,
    @SerializedName("location") val location: Location,
    @SerializedName("recent_data_new") val recentDataNew: RecentDataNew,
    @SerializedName("source") val source: String,
    @SerializedName("updated_on") val updatedOn: String,
    @SerializedName("url") val url: String
)
