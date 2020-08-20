package com.mobile.paytminsider.ankhiya.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stat {

    @SerializedName("target_id")
    @Expose
    private String mTargetId;

    @SerializedName("actualCount")
    @Expose
    private int mActualCount;

    @SerializedName("prettyCount")
    @Expose
    private int mPrettyCount;

    public Stat() {
    }

    public String getTargetId() {
        return mTargetId;
    }

    public int getActualCount() {
        return mActualCount;
    }

    public int getPrettyCount() {
        return mPrettyCount;
    }
}
