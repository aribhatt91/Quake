package com.example.aribhatt.quakereport.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aribhatt.quakereport.R;
import com.example.aribhatt.quakereport.model.Quake;

import java.util.List;

/**
 * Created by aribhatt on 03/11/17.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {

    interface Callback {
        void onItemClicked(int index, boolean longClick);

        void onIconClicked(int index);
    }

    List<Quake> quakeList;
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public void setItemDetails(Quake quake){

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

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    class QuakeViewHolder extends RecyclerView.ViewHolder{
        final View view;
        final TextView title, detail;
        final ImageView icon;

        QuakeViewHolder(View itemView){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.name);
            detail = (TextView) itemView.findViewById(R.id.detail);
            icon = (ImageView) itemView.findViewById(R.id.list_image);
            view = itemView;
        }
    }
}
