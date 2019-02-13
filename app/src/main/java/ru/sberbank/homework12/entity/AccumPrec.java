package ru.sberbank.homework12.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccumPrec {

    @SerializedName("1")
    @Expose
    private float _1;
    @SerializedName("3")
    @Expose
    private float _3;
    @SerializedName("7")
    @Expose
    private float _7;

    public float get1() {
        return _1;
    }

    public void set1(float _1) {
        this._1 = _1;
    }

    public float get3() {
        return _3;
    }

    public void set3(float _3) {
        this._3 = _3;
    }

    public float get7() {
        return _7;
    }

    public void set7(float _7) {
        this._7 = _7;
    }

}
