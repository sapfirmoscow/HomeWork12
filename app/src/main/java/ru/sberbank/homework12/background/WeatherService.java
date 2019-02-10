package ru.sberbank.homework12.background;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.sberbank.homework12.entity.ForecastModel;
import ru.sberbank.homework12.net.ApiMapper;
import ru.sberbank.homework12.net.RetrofitHelper;

public class WeatherService extends Service {

    private IBinder mBinder = new LocalBinder();
    private String TAG = "WeatherService";
    //   private ForecastModel mForecastModel = null;

    public static final Intent newIntent(Context context) {
        return new Intent(context, WeatherService.class);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public void getWeatherFromNetwork(final Back<ForecastModel> back) {

        ApiMapper apiMapper = new ApiMapper(new RetrofitHelper());
        apiMapper.getForecastAsync(new Callback<ForecastModel>() {
            @Override
            public void onResponse(Call<ForecastModel> call, Response<ForecastModel> response) {
                if (response.isSuccessful())
                    back.callback(response.body());
            }

            @Override
            public void onFailure(Call<ForecastModel> call, Throwable t) {
                Log.e(TAG, "Fail");
            }
        });
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
