package com.mobile.paytminsider.ankhiya.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.mobile.paytminsider.ankhiya.application.BaseApp;
import com.mobile.paytminsider.ankhiya.model.Event;
import com.mobile.paytminsider.ankhiya.repository.DataRepository;

import java.util.List;

/**
 * View model for Events list for a group
 */
public class GroupEventViewModel extends AndroidViewModel {

    private final LiveData<List<Event>> mEvents;

    private GroupEventViewModel(@NonNull Application application, @NonNull String groupName) {
        super(application);
        DataRepository repository = ((BaseApp) application).getRepository();
        mEvents = repository.getEventsForGroup(groupName);
    }

    public LiveData<List<Event>> getEvents() {
        return mEvents;
    }

    /**
     * Factory class for view model instantiation
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        @NonNull
        private final String mGroupName;

        public Factory(@NonNull Application application, @NonNull String groupName) {
            mApplication = application;
            mGroupName = groupName;
        }

        @SuppressWarnings("unchecked")
        @Override
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new GroupEventViewModel(mApplication, mGroupName);
        }

    }
}
