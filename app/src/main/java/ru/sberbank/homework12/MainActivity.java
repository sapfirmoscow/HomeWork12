package ru.sberbank.homework12;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ru.sberbank.homework12.background.WeatherService;
import ru.sberbank.homework12.entity.ForecastModel;

public class MainActivity extends AppCompatActivity {
    private WeatherService mWeatherService;
    private TextView textView;


    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mWeatherService = ((WeatherService.LocalBinder) service).getService();
            mWeatherService.getWeatherFromNetwork(forecast -> initsmth(forecast));//погода прилетела
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mWeatherService = null;
        }
    };

    private void initsmth(ForecastModel forecastModel) {
        textView.setText(forecastModel.getNowDt());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        initRecyclerView();
//        textView = findViewById(R.id.textView);
//        final ApiMapper apiMapper = new ApiMapper(new RetrofitHelper());
//        apiMapper.getForecastAsync(new Callback<ForecastModel>() {
//            @Override
//            public void onResponse(Call<ForecastModel> call, Response<ForecastModel> response) {
//                String s = String.valueOf(response.body().getFact().getTemp());
//                textView.setText(s + " Градусов");
//
//            }
//
//            @Override
//            public void onFailure(Call<ForecastModel> call, Throwable t) {
//
//            }
//        });

    }

    private void initRecyclerView() {

    }

    private void initListeners() {

    }

    private void initViews() {
        textView = findViewById(R.id.textView);
    }


    @Override
    protected void onResume() {
        super.onResume();
        bindService(WeatherService.newIntent(MainActivity.this), mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(mServiceConnection);
    }
}
