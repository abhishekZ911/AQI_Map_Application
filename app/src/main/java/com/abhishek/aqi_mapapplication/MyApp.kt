package com.abhishek.aqi_mapapplication

import android.app.Application
import com.abhishek.aqi_mapapplication.data.remote.RetrofitInstance
import com.abhishek.aqi_mapapplication.data.repository.AqiRepository
import com.abhishek.aqi_mapapplication.data.repository.LocationRepository

class MyApp : Application() {
    lateinit var locationRepository: LocationRepository
    lateinit var aqiRepository: AqiRepository

    override fun onCreate() {
        super.onCreate()
        locationRepository = LocationRepository(this)
        aqiRepository = AqiRepository(RetrofitInstance.api)
    }
}