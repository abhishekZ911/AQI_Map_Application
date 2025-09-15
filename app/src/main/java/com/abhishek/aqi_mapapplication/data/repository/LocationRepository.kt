package com.abhishek.aqi_mapapplication.data.repository

import android.content.Context
import android.location.Geocoder
import java.util.Locale

class LocationRepository(private val context: Context) {

    fun getPlaceName(lat: Double, lng: Double): String? {
        return try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses = geocoder.getFromLocation(lat, lng, 1)
            addresses?.get(0)?.getAddressLine(0)
        } catch (e: Exception) {
            null
        }
    }
}