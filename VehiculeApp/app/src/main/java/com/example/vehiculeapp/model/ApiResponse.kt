package com.example.vehiculeapp.model

class ApiResponse(val vehicleList: VehicleList)

class VehicleList(val status: String, val response:List<Vehicle>)

class Vehicle(val id: Int, val name: String, val icon: Icon)

class Icon(val url: IconUrl)

class IconUrl(val size50x50: String)