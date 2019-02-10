
package ru.sberbank.homework12.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("f")
    @Expose
    private boolean f;
    @SerializedName("n")
    @Expose
    private boolean n;
    @SerializedName("nr")
    @Expose
    private boolean nr;
    @SerializedName("ns")
    @Expose
    private boolean ns;
    @SerializedName("nsr")
    @Expose
    private boolean nsr;
    @SerializedName("p")
    @Expose
    private boolean p;
    @SerializedName("lat")
    @Expose
    private float lat;
    @SerializedName("lon")
    @Expose
    private float lon;
    @SerializedName("geoid")
    @Expose
    private int geoid;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("zoom")
    @Expose
    private int zoom;
    @SerializedName("tzinfo")
    @Expose
    private Tzinfo tzinfo;
    @SerializedName("def_pressure_mm")
    @Expose
    private int defPressureMm;
    @SerializedName("def_pressure_pa")
    @Expose
    private int defPressurePa;
    @SerializedName("_h")
    @Expose
    private boolean h;
    @SerializedName("url")
    @Expose
    private String url;

    public boolean isF() {
        return f;
    }

    public void setF(boolean f) {
        this.f = f;
    }

    public boolean isN() {
        return n;
    }

    public void setN(boolean n) {
        this.n = n;
    }

    public boolean isNr() {
        return nr;
    }

    public void setNr(boolean nr) {
        this.nr = nr;
    }

    public boolean isNs() {
        return ns;
    }

    public void setNs(boolean ns) {
        this.ns = ns;
    }

    public boolean isNsr() {
        return nsr;
    }

    public void setNsr(boolean nsr) {
        this.nsr = nsr;
    }

    public boolean isP() {
        return p;
    }

    public void setP(boolean p) {
        this.p = p;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public int getGeoid() {
        return geoid;
    }

    public void setGeoid(int geoid) {
        this.geoid = geoid;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public Tzinfo getTzinfo() {
        return tzinfo;
    }

    public void setTzinfo(Tzinfo tzinfo) {
        this.tzinfo = tzinfo;
    }

    public int getDefPressureMm() {
        return defPressureMm;
    }

    public void setDefPressureMm(int defPressureMm) {
        this.defPressureMm = defPressureMm;
    }

    public int getDefPressurePa() {
        return defPressurePa;
    }

    public void setDefPressurePa(int defPressurePa) {
        this.defPressurePa = defPressurePa;
    }

    public boolean isH() {
        return h;
    }

    public void setH(boolean h) {
        this.h = h;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
