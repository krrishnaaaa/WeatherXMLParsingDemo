package pcsalt.example.weatherxmlparsingdemo;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class XMLHelper extends DefaultHandler implements Tags {
	String TAG = "XMLHelper";

	int weatherCount = 0;
	Boolean currentElement = false;
	String currentValue = "";
	public static ResponseData item = null;
	public static ArrayList<ResponseData> itemList = new ArrayList<ResponseData>();

	public void get() {

		Log.i(TAG, "in processFeed()");
		String url = "http://api.worldweatheronline.com/free/v1/weather.ashx?q=28.58%2C77.33&format=xml&num_of_days=5&key=5vra6dkwsdazz5vxpfzwsz6s";
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			reader.setContentHandler(this);
			InputStream inputStream = new URL(url).openStream();
			reader.parse(new InputSource(inputStream));
		} catch (Exception e) {
			Log.e(TAG, "Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static ResponseData getItemsList() {
		return item;
	}

	public static ArrayList<ResponseData> getItemsListArray() {
		return itemList;
	}

	// Called when tag starts
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		currentElement = true;
		currentValue = "";
		if (localName.equals(TAG_MAIN)) {
			item = new ResponseData();
			itemList.clear();
		}

	}

	// Called when tag closing
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		currentElement = false;

		/** set value */
		if (localName.equalsIgnoreCase(TAG_TYPE))
			item.setType(currentValue);

		else if(localName.equalsIgnoreCase(TAG_QUERY))
			item.setQuery(currentValue);

		else if(localName.equalsIgnoreCase(TAG_OBS_TIME))
			item.setObsTime(currentValue);

		else if(localName.equalsIgnoreCase(TAG_TEMP_C))
			item.setTempC(currentValue);

		else if(localName.equalsIgnoreCase(TAG_TEMP_F))
			item.setTempF(currentValue);

		else if(localName.equalsIgnoreCase(TAG_WEATHER_ICON_URL))
			item.setWeatherIconUrl(currentValue);
		
		else if(localName.equalsIgnoreCase(TAG_WEATHER_DESC))
			switch(weatherCount) {
			case 0: item.setWeatherDesc(currentValue); break;
			case 1: item.setWeatherDesc1(currentValue); break;
			case 2: item.setWeatherDesc2(currentValue); break;
			case 3: item.setWeatherDesc3(currentValue); break;
			case 4: item.setWeatherDesc4(currentValue); break;
			}

		else if(localName.equalsIgnoreCase(TAG_WEATHER))
			weatherCount++;

		else if(localName.equalsIgnoreCase(TAG_DATE)) {
			switch(weatherCount) {
				case 1:	item.setDate1(currentValue);	break;
				case 2:	item.setDate2(currentValue);	break;
				case 3:	item.setDate3(currentValue);	break;
				case 4:	item.setDate4(currentValue);	break;
			}
		}
		
		else if(localName.equalsIgnoreCase(TAG_TEMP_MAX_C)) {
			switch(weatherCount) {
				case 1:	item.setMaxC1(currentValue);	break;
				case 2:	item.setMaxC2(currentValue);	break;
				case 3:	item.setMaxC3(currentValue);	break;
				case 4:	item.setMaxC4(currentValue);	break;
			}
		}
		
		else if(localName.equalsIgnoreCase(TAG_TEMP_MAX_F)) {
			switch(weatherCount) {
				case 1:	item.setMaxF1(currentValue);	break;
				case 2:	item.setMaxF2(currentValue);	break;
				case 3:	item.setMaxF3(currentValue);	break;
				case 4:	item.setMaxF4(currentValue);	break;
			}
		}
		
		else if(localName.equalsIgnoreCase(TAG_TEMP_MIN_C)) {
			switch(weatherCount) {
				case 1:	item.setMinC1(currentValue);	break;
				case 2:	item.setMinC2(currentValue);	break;
				case 3:	item.setMinC3(currentValue);	break;
				case 4:	item.setMinC4(currentValue);	break;
			}
		}
		
		else if(localName.equalsIgnoreCase(TAG_TEMP_MIN_F)) {
			switch(weatherCount) {
				case 1:	item.setMinF1(currentValue);	break;
				case 2:	item.setMinF2(currentValue);	break;
				case 3:	item.setMinF3(currentValue);	break;
				case 4:	item.setMinF4(currentValue);	break;
			}
		}

		else if (localName.equalsIgnoreCase(TAG_MAIN))
			itemList.add(item);

	}

	// Called to get tag characters
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (currentElement) {
			currentValue = currentValue + new String(ch, start, length);
			Log.i(TAG, "currentValue: " + currentValue);
			currentElement = false;
		}

	}
}
