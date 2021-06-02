package com.example.pcsalt.weatherxmlparsingdemo.dto

class CurrentCondition {
    var observationTime: String? = null
    var tempC = 0
    var tempF = 0
    var weatherCode = 0
    var weatherIconUrl: String? = null
    var weatherDesc: String? = null
    var windspeedMiles = 0
    var windspeedKmph = 0
    var winddirDegree = 0
    var winddir16Point: String? = null
    var precipMM = 0.0
    var precipInches = 0.0
    var humidity = 0
    var visibility = 0
    var visibilityMiles = 0
    var pressure = 0
    var pressureInches = 0
    var cloudcover = 0
    var FeelsLikeC = 0
    var FeelsLikeF = 0
    var uvIndex = 0
    override fun toString(): String {
        return "CurrentCondition(observationTime=$observationTime, tempC=$tempC, tempF=$tempF, weatherCode=$weatherCode, weatherIconUrl=$weatherIconUrl, weatherDesc=$weatherDesc, windspeedMiles=$windspeedMiles, windspeedKmph=$windspeedKmph, winddirDegree=$winddirDegree, winddir16Point=$winddir16Point, precipMM=$precipMM, precipInches=$precipInches, humidity=$humidity, visibility=$visibility, visibilityMiles=$visibilityMiles, pressure=$pressure, pressureInches=$pressureInches, cloudcover=$cloudcover, FeelsLikeC=$FeelsLikeC, FeelsLikeF=$FeelsLikeF, uvIndex=$uvIndex)"
    }

}