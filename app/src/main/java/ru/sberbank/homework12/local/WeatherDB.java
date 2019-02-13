package ru.sberbank.homework12.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.sberbank.homework12.entity.Forecast;

@Database(entities = Forecast.class, version = 2)

public abstract class WeatherDB extends RoomDatabase {

    public abstract WeatherDAO getWeatherDAO();
}
