package com.example.pcsalt.weatherxmlparsingdemo.dto

class Data {
    val currentCondition = CurrentCondition()
    val weather: ArrayList<Weather> = ArrayList()
    val climateAverage = ClimateAverage()
}