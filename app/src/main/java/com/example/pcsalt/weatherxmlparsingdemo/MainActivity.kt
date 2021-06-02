package com.example.pcsalt.weatherxmlparsingdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

            Log.d("main activity", "after parsing ${handler.getWeatherData().currentCondition}")
            // display response in UI
            launch(Dispatchers.Main) {

            }
        }
    }
}