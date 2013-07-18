package pcsalt.example.weatherxmlparsingdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tvResponse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvResponse = (TextView) findViewById(R.id.tvResponse);
		new WeatherAsync().execute();
	}

	class WeatherAsync extends AsyncTask<String, Void, Void> {
		XMLHelper helper;
		ProgressDialog pd;
		
		@Override
		protected void onPreExecute() {
			pd = ProgressDialog.show(MainActivity.this, "Weather Details", "Loading weather details...", false, false);
		}
		
		@Override
		protected Void doInBackground(String... params) {
			helper  = new XMLHelper();
			helper.get();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			ArrayList<ResponseData> list = XMLHelper.getItemsListArray();
			ResponseData rd = list.get(0);
			StringBuilder builder = new StringBuilder();
			builder.append("Current Condition:");
			builder.append("\nObservation Time: " + rd.getObsTime());
			builder.append("\nTemp (C): " + rd.getTempC());
			builder.append("\nTemp (F): " + rd.getTempF());
			builder.append("\nWeather: " + rd.getWeatherDesc());
			builder.append("\n");
			builder.append("\nDate (" + rd.getDate1() + ")");
			builder.append("\nMax (C): " + rd.getMaxC1());
			builder.append("\nMax (F): " + rd.getMaxF1());
			builder.append("\nMin (C): " + rd.getMinC1());
			builder.append("\nMin (F): " + rd.getMinF1());
			builder.append("\nWeather: " + rd.getWeatherDesc1());
			builder.append("\n");
			builder.append("\nDate (" + rd.getDate2() + ")");
			builder.append("\nMax (C): " + rd.getMaxC2());
			builder.append("\nMax (F): " + rd.getMaxF2());
			builder.append("\nMin (C): " + rd.getMinC2());
			builder.append("\nMin (F): " + rd.getMinF2());
			builder.append("\nWeather: " + rd.getWeatherDesc2());
			builder.append("\n");
			builder.append("\nDate (" + rd.getDate3() + ")");
			builder.append("\nMax (C): " + rd.getMaxC3());
			builder.append("\nMax (F): " + rd.getMaxF3());
			builder.append("\nMin (C): " + rd.getMinC3());
			builder.append("\nMin (F): " + rd.getMinF3());
			builder.append("\nWeather: " + rd.getWeatherDesc3());
			builder.append("\n");
			builder.append("\nDate (" + rd.getDate4() + ")");
			builder.append("\nMax (C): " + rd.getMaxC4());
			builder.append("\nMax (F): " + rd.getMaxF4());
			builder.append("\nMin (C): " + rd.getMinC4());
			builder.append("\nMin (F): " + rd.getMinF4());
			builder.append("\nWeather: " + rd.getWeatherDesc4());
			tvResponse.setText(builder.toString());
			pd.dismiss();
		}
	}

}
