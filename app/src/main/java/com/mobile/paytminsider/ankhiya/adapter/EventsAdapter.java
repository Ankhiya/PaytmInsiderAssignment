package com.mobile.paytminsider.ankhiya.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mobile.paytminsider.ankhiya.R;
import com.mobile.paytminsider.ankhiya.databinding.ViewHolderEventBinding;
import com.mobile.paytminsider.ankhiya.model.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Events adapter
 */
public class EventsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int S_EVENT_VIEW_TYPE_ID = 30;
    private static final int S_NO_RESULTS_VIEW_TYPE_ID = 20;
    private List<Event> mEvents;

    public EventsAdapter() {
        this.mEvents = new ArrayList<>();
    }

    /**
     * Call this method to set events data to display in recycler view
     * @param events list of events
     */
    public void setEvents(final List<Event> events) {
        this.mEvents.clear();
        this.mEvents.addAll(events);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(final int position) {
        // if list is empty, view type will be no results view
        if (mEvents.isEmpty()) {
            return S_NO_RESULTS_VIEW_TYPE_ID;
        }
        // event view
        return S_EVENT_VIEW_TYPE_ID;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == S_EVENT_VIEW_TYPE_ID) {
            View item = View.inflate(parent.getContext(), R.layout.view_holder_event, null);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            item.setLayoutParams(lp);
            return new EventViewHolder(DataBindingUtil.bind(item));
        }
        return getNoResultView(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof EventViewHolder) {
            Event event = mEvents.get(position);
            ((EventViewHolder) holder).configure(event);
        }
    }

    @Override
    public int getItemCount() {
        if (mEvents.isEmpty()) {
            return 1;
        } else {
            return mEvents.size();
        }
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {

        private ViewHolderEventBinding mBinding;

        EventViewHolder(ViewHolderEventBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void configure(@NonNull Event event) {
            Glide.with(mBinding.getRoot().getContext())
                    .load(event.getHorizontalCoverImage())
                    .into(mBinding.eventCoverImage);
            mBinding.setName(event.getName());
            mBinding.setCategory(event.getCategoryName());
            mBinding.setVenueDate(event.getVenueDateString());
            mBinding.setVenueName(event.getVenueName());
            mBinding.setPrice(event.getPriceDisplayString());
        }
    }

    private RecyclerView.ViewHolder getNoResultView(final ViewGroup viewGroup) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_holder_no_result,
                viewGroup, false);
        return new NoResultFoundViewHolder(layout);
    }

    /**
     * No result view holder
     */
    private static class NoResultFoundViewHolder extends RecyclerView.ViewHolder {

        private NoResultFoundViewHolder(@NonNull final View itemView) {
            super(itemView);
        }
    }
}
