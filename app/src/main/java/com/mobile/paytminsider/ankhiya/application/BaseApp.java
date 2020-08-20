package com.mobile.paytminsider.ankhiya.application;

import android.app.Application;

import com.mobile.paytminsider.ankhiya.repository.DataRepository;

/**
 * Android application class. Used for accessing singletons
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance();
    }

}
