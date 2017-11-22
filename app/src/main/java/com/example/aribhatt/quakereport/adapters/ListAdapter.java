package com.example.aribhatt.quakereport.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.aribhatt.quakereport.model.Quake;

import java.util.List;

/**
 * Created by aribhatt on 03/11/17.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Quake> quakeList;
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
}
