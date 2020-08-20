package com.mobile.paytminsider.ankhiya.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("latitude")
    @Expose
    private double mLatitude;

    @SerializedName("longitude")
    @Expose
    private double mLongitude;

    public Location() {
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }
}
