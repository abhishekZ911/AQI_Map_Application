package com.abhishek.aqi_mapapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContentView(R.layout.activity_main)

        val frg = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment

        frg.getMapAsync(this)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    override fun onMapReady(p0: GoogleMap) {
        googleMap = p0

        googleMap.uiSettings.isZoomControlsEnabled = true


        val startLocation = LatLng(28.6139, 77.2088)

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startLocation, 12f))

        setupCameraMoveListener()
    }

    private fun setupCameraMoveListener() {
        googleMap.setOnCameraIdleListener {
            val center: LatLng = googleMap.cameraPosition.target
            Log.d("MapCenter", "Lat: ${center.latitude}, Lng: ${center.longitude}")
        }
    }

}