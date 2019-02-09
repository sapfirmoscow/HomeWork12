package ru.sberbank.homework12.net;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface WebService {

    @GET("forecast/")
    Call<Response> getCurrentForecast(@Header("X-Yandex-API-Key") String apiKey);
}
