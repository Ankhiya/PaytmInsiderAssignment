package com.mobile.paytminsider.ankhiya.repository.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * root response class of events api
 */
public class EventListResponse {

    @SerializedName("list")
    @Expose
    private EventResponse mEventResponse;

    @SerializedName("groups")
    @Expose
    private List<String> mGroups;

    public EventListResponse() {
    }

    public List<String> getGroups() {
        return mGroups;
    }

    public EventResponse getEventResponse() {
        return mEventResponse;
    }
}
