package com.huxley.newyorktimes.activities.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.huxley.newyorktimes.R;

import butterknife.ButterKnife;

public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.EmptyViewHolder> {

    public static RecyclerView.Adapter newInstance() {
        return new EmptyAdapter();
    }

    private EmptyAdapter() {

    }

    @Override
    public EmptyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty, parent, false));
    }

    @Override
    public void onBindViewHolder(EmptyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    class EmptyViewHolder extends RecyclerView.ViewHolder {

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
