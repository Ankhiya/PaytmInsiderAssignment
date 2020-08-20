package com.mobile.paytminsider.ankhiya.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mobile.paytminsider.ankhiya.application.BaseApp;
import com.mobile.paytminsider.ankhiya.repository.DataRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private final LiveData<List<String>> mGroups;
    private final DataRepository mRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((BaseApp) application).getRepository();
        mGroups = mRepository.getGroups();
    }

    public void refresh() {
        mRepository.refreshData();
    }

    public LiveData<String> getError() {
        return mRepository.getError();
    }

    public LiveData<List<String>> getGroups() {
        return mGroups;
    }
}
