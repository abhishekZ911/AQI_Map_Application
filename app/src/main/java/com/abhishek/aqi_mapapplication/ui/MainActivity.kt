package com.abhishek.aqi_mapapplication.ui

import android.annotation.SuppressLint
import android.content.Context
import android.nfc.Tag
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.lifecycle.ViewModelProvider
import com.abhishek.aqi_mapapplication.MyApp
import com.abhishek.aqi_mapapplication.R
import com.abhishek.aqi_mapapplication.data.remote.RetrofitInstance
import com.abhishek.aqi_mapapplication.data.repository.AqiRepository
import com.abhishek.aqi_mapapplication.data.repository.LocationRepository
import com.abhishek.aqi_mapapplication.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap
    private lateinit var viewModel: MapViewModel

    lateinit var mBinding: ActivityMainBinding

    var TAG = "MAINACTIVITY"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = application as MyApp

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        val factory = MapViewModelFactory(app.locationRepository, app.aqiRepository)
        viewModel = ViewModelProvider(this, factory).get(MapViewModel::class.java)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)


        viewModel.aqiLiveData.observe(this) { data ->
            if (!data?.placeName.isNullOrEmpty() && data?.aqi != null) {
                mBinding.placeNameText.text = data.placeName
                mBinding.aqiText.text = "AQI: ${data.aqi}"
            } else {
                mBinding.placeNameText.text = "Data Not Available!"
                mBinding.aqiText.text = "AQI: --"
                Toast.makeText(this, "No data fetched", Toast.LENGTH_SHORT).show()
            }


        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        googleMap.uiSettings.isZoomControlsEnabled = true

        val startLocation = LatLng(28.6139, 77.2088)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startLocation, 12f))

        setupCameraMoveListener()
    }

    private fun setupCameraMoveListener() {
        googleMap.setOnCameraIdleListener {
            val center = googleMap.cameraPosition.target
//            viewModel.updateCenter(center.latitude, center.longitude)
            viewModel.fetchAqi(center.latitude, center.longitude)
        }
    }



}
