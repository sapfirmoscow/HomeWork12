package ru.sberbank.homework12;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.sberbank.homework12.entity.ForecastModel;
import ru.sberbank.homework12.net.ApiMapper;
import ru.sberbank.homework12.net.RetrofitHelper;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        final ApiMapper apiMapper = new ApiMapper(new RetrofitHelper());
        apiMapper.getForecastAsync(new Callback<ForecastModel>() {
            @Override
            public void onResponse(Call<ForecastModel> call, Response<ForecastModel> response) {
                String s = String.valueOf(response.body().getFact().getTemp());
                textView.setText(s + " Градусов");

            }

            @Override
            public void onFailure(Call<ForecastModel> call, Throwable t) {

            }
        });

    }


}
