package com.abhishek.aqi_mapapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek.aqi_mapapplication.data.model.AQILiveData
import com.abhishek.aqi_mapapplication.data.model.ApiResponse
import com.abhishek.aqi_mapapplication.data.repository.AqiRepository
import com.abhishek.aqi_mapapplication.data.repository.LocationRepository
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MapViewModel(
    private val locationRepository: LocationRepository,
    private val aqiRepository: AqiRepository
) : ViewModel() {

    private val _centerLatLng = MutableLiveData<LatLng>()
    val centerLatLng: LiveData<LatLng> = _centerLatLng

    private val _placeName = MutableLiveData<String>()
    val placeName: LiveData<String> = _placeName

    private val _aqiLiveData = MutableLiveData<AQILiveData?>()
    val aqiLiveData: LiveData<AQILiveData?> get() = _aqiLiveData

    fun updateCenter(lat: Double, lng: Double) {
        val latLng = LatLng(lat, lng)
        _centerLatLng.value = latLng

        viewModelScope.launch(Dispatchers.IO) {
            val place = locationRepository.getPlaceName(lat, lng)
            place?.let {
                _placeName.postValue(it)
            }
        }
    }


    fun fetchAqi(lat: Double, lng: Double) {
        viewModelScope.launch {
            try {
                val result = aqiRepository.getAqi(lat, lng)
                val validStation = result.stations.firstOrNull()
                validStation?.let{
                    val place = it.cityName
                    val aqi = it.recentDataNew.aqiInd
                    val obj = AQILiveData(place, aqi)
                    _aqiLiveData.postValue(obj)
                } ?: run{

                        _aqiLiveData.postValue(AQILiveData(null, null))
                }
            } catch (e: Exception) {
                _aqiLiveData.postValue(null)

            }
        }
    }
}
