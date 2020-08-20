package com.mobile.paytminsider.ankhiya.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import static com.mobile.paytminsider.ankhiya.utils.StringUtils.NA;

/**
 * Model class for Event
 */
public class Event implements EventContract {

    @SerializedName("_id")
    @Expose
    private String mId;

    @SerializedName("min_show_start_time")
    @Expose
    private long mMinShowStartTime;

    @SerializedName("name")
    @Expose
    private String mName;

    @SerializedName("type")
    @Expose
    private String mType;

    @SerializedName("slug")
    @Expose
    private String mSlug;

    @SerializedName("horizontal_cover_image")
    @Expose
    private String mHorizontalCoverImage;

    @SerializedName("vertical_cover_image")
    @Expose
    private String mVerticalCoverImage;

    @SerializedName("city")
    @Expose
    private String mCity;

    @SerializedName("venue_id")
    @Expose
    private String mVenueId;

    @SerializedName("venue_name")
    @Expose
    private String mVenueName;

    @SerializedName("venue_date_string")
    @Expose
    private String mVenueDateString;

    @SerializedName("event_state")
    @Expose
    private String mEventState;

    @SerializedName("is_rsvp")
    @Expose
    private boolean mIsRSVP;

    @SerializedName("price_display_string")
    @Expose
    private String mPriceDisplayString;

    @SerializedName("action_button_text")
    @Expose
    private String mActionButtonText;

    @SerializedName("communication_strategy")
    @Expose
    private String mCommunicationStrategy;

    @SerializedName("tags")
    @Expose
    private List<Tag> mTags;

    @SerializedName("model")
    @Expose
    private String mModel;

    @SerializedName("popularity_score")
    @Expose
    private float mPopularityScore;

    @SerializedName("purchase_visibility")
    @Expose
    private String mPurchaseVisibility;

    @SerializedName("min_price")
    @Expose
    private long mMinPrice;

    @SerializedName("venue_geolocation")
    @Expose
    private Location mVenueGeolocation;

    @SerializedName("favStats")
    @Expose
    private Stat mFavStat;

    @SerializedName("applicable_filters")
    @Expose
    private List<String> mApplicableFilters;

    @SerializedName("category_id")
    @Expose
    private GroupNCategory nCategory;

    public Event() {
    }

    @Override
    public String getId() {
        return mId;
    }

    @Override
    public long getMinShowStartTime() {
        return mMinShowStartTime;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public String getType() {
        return mType;
    }

    @Override
    public String getSlug() {
        return mSlug;
    }

    @Override
    public String getHorizontalCoverImage() {
        return mHorizontalCoverImage;
    }

    @Override
    public String getVerticalCoverImage() {
        return mVerticalCoverImage;
    }

    @Override
    public String getCity() {
        return mCity;
    }

    @Override
    public String getVenueId() {
        return mVenueId;
    }

    @Override
    public String getVenueName() {
        return mVenueName;
    }

    @Override
    public String getVenueDateString() {
        return mVenueDateString;
    }

    @Override
    public String getEventState() {
        return mEventState;
    }

    @Override
    public boolean isRSVP() {
        return mIsRSVP;
    }

    @Override
    public String getPriceDisplayString() {
        return mPriceDisplayString;
    }

    @Override
    public String getActionButtonText() {
        return mActionButtonText;
    }

    @Override
    public String getCommunicationStrategy() {
        return mCommunicationStrategy;
    }

    @Override
    public List<Tag> getTags() {
        return mTags;
    }

    @Override
    public String getModel() {
        return mModel;
    }

    @Override
    public float getPopularityScore() {
        return mPopularityScore;
    }

    @Override
    public String getPurchaseVisibility() {
        return mPurchaseVisibility;
    }

    @Override
    public long getMinPrice() {
        return mMinPrice;
    }

    @Override
    public Location getVenueGeolocation() {
        return mVenueGeolocation;
    }

    @Override
    public Stat getFavStat() {
        return mFavStat;
    }

    @Override
    public List<String> getApplicableFilters() {
        return mApplicableFilters;
    }

    @Override
    public String getCategoryName() {
        return nCategory != null ? nCategory.getName() : NA;
    }
}
