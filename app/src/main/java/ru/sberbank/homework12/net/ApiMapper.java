package ru.sberbank.homework12.net;

import java.io.IOException;

import retrofit2.Callback;
import ru.sberbank.homework12.WeatherApplication;
import ru.sberbank.homework12.entity.ForecastModel;

public class ApiMapper {
    private RetrofitHelper mHelper;

    public ApiMapper(RetrofitHelper helper) {
        mHelper = helper;
    }


    public void getForecastAsync(Callback<ForecastModel> forecastModelCallback) {
        mHelper.getService().getCurrentForecast(WeatherApplication.X_YANDEX_API_KEY, "55.75222", "37.61556", false, false, 7).enqueue(forecastModelCallback);

    }

    public ForecastModel getForecastSync() throws IOException {
        return mHelper.getService().getCurrentForecast(WeatherApplication.X_YANDEX_API_KEY, "55.75222", "37.61556", false, false, 7).execute().body();
    }

}
