package ru.sberbank.homework12.entity;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fact {

    @SerializedName("temp")
    @Expose
    private int temp;
    @SerializedName("feels_like")
    @Expose
    private int feelsLike;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("wind_speed")
    @Expose
    private float windSpeed;
    @SerializedName("wind_gust")
    @Expose
    private float windGust;
    @SerializedName("wind_dir")
    @Expose
    private String windDir;
    @SerializedName("pressure_mm")
    @Expose
    private int pressureMm;
    @SerializedName("pressure_pa")
    @Expose
    private int pressurePa;
    @SerializedName("humidity")
    @Expose
    private int humidity;
    @SerializedName("uv_index")
    @Expose
    private int uvIndex;
    @SerializedName("soil_temp")
    @Expose
    private int soilTemp;
    @SerializedName("soil_moisture")
    @Expose
    private float soilMoisture;
    @SerializedName("daytime")
    @Expose
    private String daytime;
    @SerializedName("polar")
    @Expose
    private boolean polar;
    @SerializedName("season")
    @Expose
    private String season;
    @SerializedName("obs_time")
    @Expose
    private int obsTime;
    @SerializedName("accum_prec")
    @Expose
    @Embedded
    private AccumPrec accumPrec;
    @SerializedName("source")
    @Expose
    private String source;

    public Fact(int temp, int feelsLike, String icon, String condition, float windSpeed, float windGust, String windDir, int pressureMm, int pressurePa, int humidity, int uvIndex, int soilTemp, float soilMoisture, String daytime, boolean polar, String season, int obsTime, AccumPrec accumPrec, String source) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.icon = icon;
        this.condition = condition;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windDir = windDir;
        this.pressureMm = pressureMm;
        this.pressurePa = pressurePa;
        this.humidity = humidity;
        this.uvIndex = uvIndex;
        this.soilTemp = soilTemp;
        this.soilMoisture = soilMoisture;
        this.daytime = daytime;
        this.polar = polar;
        this.season = season;
        this.obsTime = obsTime;
        this.accumPrec = accumPrec;
        this.source = source;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(int feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getWindGust() {
        return windGust;
    }

    public void setWindGust(float windGust) {
        this.windGust = windGust;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public int getPressureMm() {
        return pressureMm;
    }

    public void setPressureMm(int pressureMm) {
        this.pressureMm = pressureMm;
    }

    public int getPressurePa() {
        return pressurePa;
    }

    public void setPressurePa(int pressurePa) {
        this.pressurePa = pressurePa;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public int getSoilTemp() {
        return soilTemp;
    }

    public void setSoilTemp(int soilTemp) {
        this.soilTemp = soilTemp;
    }

    public float getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(float soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public boolean isPolar() {
        return polar;
    }

    public void setPolar(boolean polar) {
        this.polar = polar;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getObsTime() {
        return obsTime;
    }

    public void setObsTime(int obsTime) {
        this.obsTime = obsTime;
    }

    public AccumPrec getAccumPrec() {
        return accumPrec;
    }

    public void setAccumPrec(AccumPrec accumPrec) {
        this.accumPrec = accumPrec;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
