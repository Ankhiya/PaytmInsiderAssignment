package com.mobile.paytminsider.ankhiya.repository.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mobile.paytminsider.ankhiya.model.Event;

import java.util.List;
import java.util.Map;

/**
 * main event list
 */
public class EventResponse {

    @SerializedName("groupwiseList")
    @Expose
    private Map<String, List<String>> mGroupWiseList;

    @SerializedName("masterList")
    @Expose
    private Map<String, Event> mMasterList;

    public EventResponse() {
    }

    public Map<String, List<String>> getGroupWiseList() {
        return mGroupWiseList;
    }

    public Map<String, Event> getMasterList() {
        return mMasterList;
    }
}
