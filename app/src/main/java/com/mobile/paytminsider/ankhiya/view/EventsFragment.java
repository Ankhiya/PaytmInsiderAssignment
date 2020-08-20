package com.mobile.paytminsider.ankhiya.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.paytminsider.ankhiya.R;
import com.mobile.paytminsider.ankhiya.adapter.EventsAdapter;
import com.mobile.paytminsider.ankhiya.model.Event;
import com.mobile.paytminsider.ankhiya.viewmodel.GroupEventViewModel;

import java.util.List;

/**
 * Events fragment
 */
public class EventsFragment extends Fragment {

    private static final String KEY_GROUP_NAME = "group_name";
    private static final String TAG = "EventsFragment";
    private EventsAdapter mEventsAdapter;

    /**
     * newInstance method
     * @param groupName group name
     * @return instance of EventsFragment
     */
    public static EventsFragment forGroup(@NonNull String groupName) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        args.putString(KEY_GROUP_NAME, groupName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || getArguments().getString(KEY_GROUP_NAME) == null) {
            throw new IllegalArgumentException(getResources().getString(R.string.must_initialize_with_group_name));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_list, container,
                false);
        mEventsAdapter = new EventsAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.eventsRecyclerView);
        recyclerView.setAdapter(mEventsAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GroupEventViewModel.Factory factory
                = new GroupEventViewModel.Factory(requireActivity().getApplication(),
                requireArguments().getString(KEY_GROUP_NAME));
        GroupEventViewModel viewModel = new ViewModelProvider(this, factory)
                .get(GroupEventViewModel.class);
        subscribeUi(viewModel.getEvents());
    }

    @Override
    public void onDestroyView() {
        mEventsAdapter = null;
        super.onDestroyView();
    }

    private void subscribeUi(LiveData<List<Event>> liveData) {
        liveData.observe(getViewLifecycleOwner(), events -> mEventsAdapter.setEvents(events));
    }
}
