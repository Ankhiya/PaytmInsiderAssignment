package com.mobile.paytminsider.ankhiya.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class for Group and Category
 */
public class GroupNCategory {

    @SerializedName("_id")
    @Expose
    private String mId;

    @SerializedName("name")
    @Expose
    private String mName;

    @SerializedName("icon_img")
    @Expose
    private String mIconImage;

    public GroupNCategory() {
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getIconImage() {
        return mIconImage;
    }
}
