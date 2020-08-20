package com.mobile.paytminsider.ankhiya.repository.network;

import com.mobile.paytminsider.ankhiya.repository.network.response.EventListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Events service
 */
public interface EventService {

    @GET("home?norm=1&filterBy=go-out&city=noida")
    Call<EventListResponse> getEvents();
}
