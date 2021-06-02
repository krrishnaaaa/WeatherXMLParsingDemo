package com.example.pcsalt.weatherxmlparsingdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pcsalt.weatherxmlparsingdemo.databinding.ActivityMainBinding
import com.example.pcsalt.weatherxmlparsingdemo.dto.Data
import com.example.pcsalt.weatherxmlparsingdemo.handler.XmlContentHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.xml.sax.InputSource
import org.xml.sax.XMLReader
import java.io.InputStream
import java.net.URL
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var weatherData: Data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    private fun getData() {
        GlobalScope.launch(Dispatchers.IO) {
            // Get Data from api
            val dataPath =
                "https://api.worldweatheronline.com/premium/v1/weather.ashx?q=28.58%2C77.33&format=xml&num_of_days=5&key=e1d208e2178f4ea59e542223210206"
            val factory: SAXParserFactory = SAXParserFactory.newInstance()
            val parser: SAXParser = factory.newSAXParser()
            val reader: XMLReader = parser.xmlReader
            val handler = XmlContentHandler()
            reader.contentHandler = handler
            val inputStream: InputStream = URL(dataPath).openStream()
            reader.parse(InputSource(inputStream))

            weatherData = handler.getWeatherData()

            // display response in UI
            launch(Dispatchers.Main) {
                updateUi()
            }
        }
    }

    private fun updateUi() {

        weatherData?.currentCondition?.let {
            binding.apply {
                tvObserveTime.text = it.observationTime
                tvTemp.text = String.format("%d C (%d F)", it.tempC, it.tempF)
                tvUvLevel.text = "UV Index ${it.uvIndex}"
                tvTempDesc.text = it.weatherDesc
            }
        }

    }
}