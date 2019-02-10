
package ru.sberbank.homework12.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hour {

    @SerializedName("hour")
    @Expose
    private String hour;
    @SerializedName("hour_ts")
    @Expose
    private int hourTs;
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
    @SerializedName("prec_mm")
    @Expose
    private float precMm;
    @SerializedName("prec_period")
    @Expose
    private int precPeriod;
    @SerializedName("prec_prob")
    @Expose
    private int precProb;
    @SerializedName("_nowcast")
    @Expose
    private boolean nowcast;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getHourTs() {
        return hourTs;
    }

    public void setHourTs(int hourTs) {
        this.hourTs = hourTs;
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

    public float getPrecMm() {
        return precMm;
    }

    public void setPrecMm(float precMm) {
        this.precMm = precMm;
    }

    public int getPrecPeriod() {
        return precPeriod;
    }

    public void setPrecPeriod(int precPeriod) {
        this.precPeriod = precPeriod;
    }

    public int getPrecProb() {
        return precProb;
    }

    public void setPrecProb(int precProb) {
        this.precProb = precProb;
    }

    public boolean isNowcast() {
        return nowcast;
    }

    public void setNowcast(boolean nowcast) {
        this.nowcast = nowcast;
    }

}
