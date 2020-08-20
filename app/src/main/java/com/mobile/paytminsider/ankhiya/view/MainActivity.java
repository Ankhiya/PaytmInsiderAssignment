package com.mobile.paytminsider.ankhiya.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.tabs.TabLayoutMediator;
import com.mobile.paytminsider.ankhiya.R;
import com.mobile.paytminsider.ankhiya.adapter.GroupsAdapter;
import com.mobile.paytminsider.ankhiya.databinding.ActivityMainBinding;
import com.mobile.paytminsider.ankhiya.viewmodel.MainActivityViewModel;

import java.util.List;

/**
 * Launcher activity
 */
public class MainActivity extends AppCompatActivity {

    private GroupsAdapter mGroupAdapter;
    private ActivityMainBinding mBinding;
    private MainActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mViewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        initialViewSettings();
        initViewPager();
        setListeners();
        subscribeGroups(mViewModel.getGroups());
        subscribeError(mViewModel.getError());
    }

    private void setListeners() {
        mBinding.swipeRefreshLayout.setOnRefreshListener(this::refresh);
        mBinding.retry.setOnClickListener(view -> refresh());
    }

    private void initViewPager() {
        mGroupAdapter = new GroupsAdapter(this);
        mBinding.eventsViewPager.setOffscreenPageLimit(3);
        mBinding.eventsViewPager.setAdapter(mGroupAdapter);
    }

    private void initialViewSettings() {
        mBinding.setLoading(true);
        mBinding.setError(null);
    }

    private void refresh() {
        mGroupAdapter.reset();
        mViewModel.refresh();
        initialViewSettings();
    }

    private void stopRefreshing() {
        if (mBinding.swipeRefreshLayout.isRefreshing()) {
            mBinding.swipeRefreshLayout.setRefreshing(false);
        }
    }

    private void subscribeError(LiveData<String> error) {
        error.observe(this, errorString -> {
            mBinding.setLoading(false);
            mBinding.setError(errorString);
            stopRefreshing();
        });
    }

    private void subscribeGroups(LiveData<List<String>> groups) {
        groups.observe(this, groupList -> {
            stopRefreshing();
            mBinding.setLoading(false);
            mBinding.setError(null);
            mGroupAdapter.setGroups(groupList);
            new TabLayoutMediator(mBinding.groupTabLayout, mBinding.eventsViewPager,
                    (tab, position) -> tab.setText(groupList.get(position))).attach();
        });
    }

    @Override
    protected void onDestroy() {
        mGroupAdapter = null;
        super.onDestroy();
    }
}
