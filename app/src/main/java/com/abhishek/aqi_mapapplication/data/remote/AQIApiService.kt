package com.abhishek.aqi_mapapplication.data.remote

import com.abhishek.aqi_mapapplication.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AqiApiService {
    @GET("getMapData")
    suspend fun getAqi(
        @Query("lat") lat: Double,
        @Query("lon") lng: Double,
        @Query("aqi_type") aqiType: String = "IND",
        @Query("zoom_level") zoomLevel: Int = 12
    ): ApiResponse
}
