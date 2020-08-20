package com.mobile.paytminsider.ankhiya.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mobile.paytminsider.ankhiya.view.EventsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Event groups adapter
 */
public class GroupsAdapter extends FragmentStateAdapter {

    private List<String> mGroups;

    public void reset() {
        mGroups.clear();
        notifyDataSetChanged();
    }

    public GroupsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        mGroups = new ArrayList<>();
    }

    /**
     * Call this method to set list of groups
     * @param groups list of groups
     */
    public void setGroups(final List<String> groups) {
        mGroups.clear();
        mGroups.addAll(groups);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return EventsFragment.forGroup(mGroups.get(position));
    }

    @Override
    public int getItemCount() {
        return mGroups.size();
    }
}
