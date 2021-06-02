package com.example.pcsalt.weatherxmlparsingdemo.handler

import android.util.Log
import com.example.pcsalt.weatherxmlparsingdemo.dto.Data
import com.example.pcsalt.weatherxmlparsingdemo.dto.Weather
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler
import java.util.*

class XmlContentHandler : DefaultHandler() {

    private var isCurrent = false
    private var currentValue = ""
    private var tagStack = Stack<String>()
    private var data = Data()

    fun getWeatherData(): Data = data

    override fun startElement(
        uri: String?,
        localName: String?,
        qName: String?,
        attributes: Attributes?
    ) {
        isCurrent = true
        currentValue = ""
        when (localName) {
            WeatherTags.CURRENT_CONDITION -> {
                tagStack.push(WeatherTags.CURRENT_CONDITION)
            }
            WeatherTags.WEATHER -> {
                data.weather.add(Weather())
                tagStack.push(WeatherTags.WEATHER)
            }
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        isCurrent = false

        if (tagStack.isEmpty()) return

        when (tagStack.peek()) {
            WeatherTags.CURRENT_CONDITION -> putCurrentConditionData(localName)
            WeatherTags.WEATHER -> putWeatherData(localName)
        }
        when (localName) {
            WeatherTags.CURRENT_CONDITION, WeatherTags.WEATHER -> {
                tagStack.pop()
            }
        }
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        if (isCurrent) {
            currentValue += ch?.let { String(it, start, length) }
            isCurrent = false
            Log.d("parsing", "value: $currentValue")
        }
    }

    private fun putCurrentConditionData(localName: String?) {
        when (localName) {
            WeatherTags.OBSERVATION_TIME -> data.currentCondition.observationTime = currentValue
            WeatherTags.TEMP__C -> data.currentCondition.tempC = currentValue.toInt()
            WeatherTags.TEMP__F -> data.currentCondition.tempF = currentValue.toInt()
            WeatherTags.WEATHER_ICON_URL -> data.currentCondition.weatherIconUrl = currentValue
            WeatherTags.WEATHER_DESC -> data.currentCondition.weatherDesc = currentValue
            WeatherTags.FEELS_LIKE_C -> data.currentCondition.FeelsLikeC = currentValue.toInt()
            WeatherTags.FEELS_LIKE_F -> data.currentCondition.FeelsLikeF = currentValue.toInt()
            WeatherTags.UV_INDEX -> data.currentCondition.uvIndex = currentValue.toInt()
        }
    }

    private fun putWeatherData(localName: String?) {
        val weather = data.weather[data.weather.lastIndex]
        when (localName) {
            WeatherTags.DATE -> weather.date = currentValue
            WeatherTags.MAX_TEMP_C -> weather.maxtempC = currentValue.toInt()
            WeatherTags.MAX_TEMP_F -> weather.maxtempF = currentValue.toInt()
            WeatherTags.MIN_TEMP_C -> weather.mintempC = currentValue.toInt()
            WeatherTags.MIN_TEMP_F -> weather.mintempF = currentValue.toInt()
            WeatherTags.AVG_TEMP_C -> weather.avgtempC = currentValue.toInt()
            WeatherTags.AVG_TEMP_F -> weather.avgtempF = currentValue.toInt()
        }
    }
}