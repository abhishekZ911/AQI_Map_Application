# AQI Map Application

A simple Android app that shows real-time **Air Quality Index (AQI)** information for a location using Google Maps. The app fetches AQI data for the center of the map as the user moves the camera and displays it in a clean card overlay.

---

## Features

- Google Maps integration with a **center marker**.
- Shows **place name** and **AQI value** in a card overlay.
- Fetches AQI data from a REST API.
- Updates AQI dynamically as the map moves.
- **Connectivity listener** to notify the user when there is no internet connection.
- Handles devices with **display cutouts / notch** (safe layout).
- Built with **MVVM architecture** for clean separation of concerns.

---



## Tech Stack

- **Kotlin**  
- **Android Jetpack:** ViewModel, LiveData, ViewBinding  
- **Google Maps SDK**  
- **Retrofit + OkHttp + Gson** for API calls  
- **Coroutines** for asynchronous operations  
- **Material Components** for UI (CardView, Toolbar)  

---

