package com.abhishek.aqi_mapapplication.data.repository

import com.abhishek.aqi_mapapplication.data.model.ApiResponse
import com.abhishek.aqi_mapapplication.data.remote.AqiApiService

class AqiRepository(private val api: AqiApiService) {
    suspend fun getAqi(lat: Double, lng: Double): ApiResponse {
        return api.getAqi(lat, lng)
    }
}
