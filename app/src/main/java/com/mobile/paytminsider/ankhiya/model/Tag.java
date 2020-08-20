package com.mobile.paytminsider.ankhiya.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tag {

    @SerializedName("is_featured")
    @Expose
    private boolean mIsFeatured;

    @SerializedName("is_carousel")
    @Expose
    private boolean mIsCarousel;

    @SerializedName("is_pick")
    @Expose
    private boolean mIsPick;

    @SerializedName("is_primary_interest")
    @Expose
    private boolean mIsPrimaryInterest;

    @SerializedName("_id")
    @Expose
    private String mId;

    @SerializedName("tag_id")
    @Expose
    private String mTagId;

    @SerializedName("priority")
    @Expose
    private int mPriority;

    @SerializedName("carousel_position")
    @Expose
    private int mCarouselPosition;

    public Tag() {
    }

    public boolean isFeatured() {
        return mIsFeatured;
    }

    public boolean isCarousel() {
        return mIsCarousel;
    }

    public boolean isPick() {
        return mIsPick;
    }

    public boolean isPrimaryInterest() {
        return mIsPrimaryInterest;
    }

    public String getId() {
        return mId;
    }

    public String getTagId() {
        return mTagId;
    }

    public int getPriority() {
        return mPriority;
    }

    public int getCarouselPosition() {
        return mCarouselPosition;
    }
}
