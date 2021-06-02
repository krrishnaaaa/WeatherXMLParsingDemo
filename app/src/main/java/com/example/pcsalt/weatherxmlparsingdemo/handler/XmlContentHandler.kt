package com.example.pcsalt.weatherxmlparsingdemo.handler

import android.util.Log
import com.example.pcsalt.weatherxmlparsingdemo.dto.CurrentCondition
import com.example.pcsalt.weatherxmlparsingdemo.dto.Data
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

class XmlContentHandler : DefaultHandler() {

    private var isCurrent = false
    private var currentValue = ""
    private var currentTag = ""
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
                data.currentCondition = CurrentCondition()
                currentTag = WeatherTags.CURRENT_CONDITION
            }
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        isCurrent = false
        if (currentTag == WeatherTags.CURRENT_CONDITION) {
            when (localName) {
                WeatherTags.TEMP_C -> data.currentCondition?.tempC = currentValue.toInt()
                WeatherTags.TEMP_F -> data.currentCondition?.tempF = currentValue.toInt()
                WeatherTags.WEATHER_ICON_URL -> data.currentCondition?.weatherIconUrl = currentValue
                WeatherTags.WEATHER_DESC -> data.currentCondition?.weatherDesc = currentValue
                WeatherTags.UV_INDEX -> data.currentCondition?.uvIndex = currentValue.toInt()
            }
        }
        if (localName == WeatherTags.CURRENT_CONDITION) {
            currentTag = ""
        }
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        if (isCurrent) {
            currentValue += ch?.let { String(it, start, length) }
            isCurrent = false
            Log.d("parsing", "value: $currentValue")
        }
    }
}