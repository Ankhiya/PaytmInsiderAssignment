package com.mobile.paytminsider.ankhiya.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.mobile.paytminsider.ankhiya.model.Event;
import com.mobile.paytminsider.ankhiya.repository.network.EventService;
import com.mobile.paytminsider.ankhiya.repository.network.RetrofitClient;
import com.mobile.paytminsider.ankhiya.repository.network.response.EventListResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Repository class to get data from network
 */
public class DataRepository {

    private static DataRepository sInstance;
    private final EventService mEventsService;
    private MutableLiveData<EventListResponse> mMainData;
    private MutableLiveData<List<String>> mGroups;
    private MutableLiveData<String> mError;

    private DataRepository() {
        mEventsService = RetrofitClient.createService(EventService.class);
        mMainData = new MutableLiveData<>();
        mGroups = new MutableLiveData<>();
        mError = new MutableLiveData<>();
        loadData();
    }

    /**
     * Instance method
     *
     * @return instance of data repository
     */
    public static DataRepository getInstance() {
        if (sInstance == null) {
            sInstance = new DataRepository();
        }
        return sInstance;
    }

    /**
     * Listen to this live data for network error
     *
     * @return error live data
     */
    public LiveData<String> getError() {
        return mError;
    }

    /**
     * Listen to this live data for groups list
     *
     * @return group list live data
     */
    public LiveData<List<String>> getGroups() {
        return mGroups;
    }

    /**
     * Listen to this live data for events list
     *
     * @param group group id
     * @return list of events for particular group
     */
    public LiveData<List<Event>> getEventsForGroup(@NonNull String group) {
        return Transformations.map(mMainData, eventListResponse -> {
            List<Event> events = new ArrayList<>();
            List<String> eventIds = eventListResponse.getEventResponse().getGroupWiseList().get(group);
            if (eventIds != null) {
                for (String eventId : eventIds) {
                    Event event = eventListResponse.getEventResponse().getMasterList().get(eventId);
                    events.add(event);
                }
            }
            return events;
        });
    }

    /**
     * Call this method to reload data
     */
    public void refreshData() {
        loadData();
    }

    private void loadData() {
        mEventsService.getEvents()
                .enqueue(new Callback<EventListResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<EventListResponse> call,
                                           @NonNull Response<EventListResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            EventListResponse eventListResponse = response.body();
                            mMainData.setValue(eventListResponse);
                            mGroups.setValue(eventListResponse.getGroups());
                        } else {
                            mError.setValue("No results found");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<EventListResponse> call,
                                          @NonNull Throwable t) {
                        if (t instanceof IOException) {
                            mError.setValue("No internet connection");
                        } else {
                            mError.setValue(t.getLocalizedMessage());
                        }
                    }
                });
    }
}
