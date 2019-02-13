package ru.sberbank.homework12;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import ru.sberbank.homework12.background.WeatherService;
import ru.sberbank.homework12.entity.Forecast;
import ru.sberbank.homework12.recycler.MyAdapter;
import ru.sberbank.homework12.recycler.RecyclerItemClickListener;


public class MainActivity extends AppCompatActivity implements NetworkStateReceiver.NetworkStateReceiverListener {
    private WeatherService mWeatherService;
    private NetworkStateReceiver mNetworkStateReceiver;
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mWeatherService = ((WeatherService.LocalBinder) service).getService();
            getWeatherFromService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mWeatherService = null;
        }
    };

    private void forecastFromService(List<Forecast> forecasts) {
        mMyAdapter.setData(forecasts);
    }

    private void getWeatherFromService() {
        if (mWeatherService != null)
            mWeatherService.getForecast(forecasts -> forecastFromService(forecasts));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initRecyclerView();
        initReceiver();
        initListeners();
    }

    private void initReceiver() {
        mNetworkStateReceiver = new NetworkStateReceiver();
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mMyAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);


    }

    private void initListeners() {
        mNetworkStateReceiver.addListener(this);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Forecast forecast = mMyAdapter.getItemForecast(position);
                Intent intent = DetailActivity.newIntent(MainActivity.this, forecast);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
    }


    @Override
    protected void onResume() {
        super.onResume();
        bindService(WeatherService.newIntent(MainActivity.this), mServiceConnection, Context.BIND_AUTO_CREATE);
        this.registerReceiver(mNetworkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));

    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(mServiceConnection);
        mNetworkStateReceiver.removeListener(this);
        this.unregisterReceiver(mNetworkStateReceiver);
    }

    @Override
    public void networkAvailable() {
        Toast.makeText(MainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
        getWeatherFromService();
    }

    @Override
    public void networkUnavailable() {
        Toast.makeText(MainActivity.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
    }
}
