package com.example.pcsalt.weatherxmlparsingdemo.dto

import java.util.*

class Weather {
    var date: Date? = null
    var astronomy: Astronomy? = null
    var maxtempC = 0
    var maxtempF = 0
    var mintempC = 0
    var mintempF = 0
    var avgtempC = 0
    var avgtempF = 0
    var totalSnow_cm = 0.0
    var sunHour = 0.0
    var uvIndex = 0
    var hourly: List<Hourly>? = null

}