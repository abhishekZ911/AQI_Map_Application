package com.abhishek.aqi_mapapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abhishek.aqi_mapapplication.data.repository.AqiRepository
import com.abhishek.aqi_mapapplication.data.repository.LocationRepository

class MapViewModelFactory(private val repository: LocationRepository, private val aqiRepository: AqiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MapViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MapViewModel(repository,aqiRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
