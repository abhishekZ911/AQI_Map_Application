package com.abhishek.aqi_mapapplication.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ApiResponse(
    @SerializedName("stations") val stations: List<Station>
)
