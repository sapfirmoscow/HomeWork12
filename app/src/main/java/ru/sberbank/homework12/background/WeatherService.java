package ru.sberbank.homework12.background;

import android.annotation.SuppressLint;
import android.app.Service;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;

import java.io.IOException;
import java.util.List;

import ru.sberbank.homework12.entity.Forecast;
import ru.sberbank.homework12.local.WeatherDB;
import ru.sberbank.homework12.net.ApiMapper;
import ru.sberbank.homework12.net.RetrofitHelper;

public class WeatherService extends Service {

    private IBinder mBinder = new LocalBinder();
    private String TAG = "WeatherService";
    private final String DB_NAME = "weather";
    private WeatherDB weatherDB;


    public static final Intent newIntent(Context context) {
        return new Intent(context, WeatherService.class);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        weatherDB = Room.databaseBuilder(getBaseContext(), WeatherDB.class, DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private void getWeatherFromNetwork() {
        ApiMapper apiMapper = new ApiMapper(new RetrofitHelper());
        try {
            List<Forecast> forecasts = apiMapper.getForecastSync().getForecasts();
            weatherDB.getWeatherDAO().setDailyForecasts(forecasts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Forecast> getWeatherFromDB() {
        return weatherDB.getWeatherDAO().getForecast();
    }

    @SuppressLint("StaticFieldLeak")
    public void getForecast(Back<List<Forecast>> back) {
        List<Forecast> forecasts = null;
        if (isOnline()) {
            new AsyncTask<Void, Void, List<Forecast>>() {

                @Override
                protected List<Forecast> doInBackground(Void... voids) {
                    getWeatherFromNetwork();
                    return getWeatherFromDB();
                }

                @Override
                protected void onPostExecute(List<Forecast> forecasts) {
                    super.onPostExecute(forecasts);
                    back.callback(forecasts);
                }
            }.execute();
        } else {
            forecasts = getWeatherFromDB();
            back.callback(forecasts);
        }
    }

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;
    }

    public interface Back<T> {
        void callback(T value);
    }

    public class LocalBinder extends Binder {
        public WeatherService getService() {
            return WeatherService.this;
        }
    }
}
