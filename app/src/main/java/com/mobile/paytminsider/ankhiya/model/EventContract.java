package com.mobile.paytminsider.ankhiya.model;

import java.util.List;

public interface EventContract {

    String getId();

    long getMinShowStartTime();

    String getName();

    String getType();

    String getSlug();

    String getHorizontalCoverImage();

    String getVerticalCoverImage();

    String getCity();

    String getVenueId();

    String getVenueName();

    String getVenueDateString();

    String getEventState();

    boolean isRSVP();

    String getPriceDisplayString();

    String getActionButtonText();

    String getCommunicationStrategy();

    List<Tag> getTags();

    String getModel();

    float getPopularityScore();

    String getPurchaseVisibility();

    long getMinPrice();

    Location getVenueGeolocation();

    Stat getFavStat();

    List<String> getApplicableFilters();

    String getCategoryName();
}
