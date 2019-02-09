package ru.sberbank.homework12.net;

import retrofit2.Call;
import retrofit2.Response;

public interface Callback<T> {
    void onRespone(Call<T> call, Response<T> response);
    void onFailure(Call<T> call,Throwable t);
}
