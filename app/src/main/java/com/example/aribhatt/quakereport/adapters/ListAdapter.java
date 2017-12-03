package com.example.aribhatt.quakereport.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.aribhatt.quakereport.R;
import com.example.aribhatt.quakereport.model.Properties;
import com.example.aribhatt.quakereport.model.Quake;
import com.example.aribhatt.quakereport.utils.Util;

import java.util.List;

/**
 * Created by aribhatt on 03/11/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.QuakeViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    List<Quake> quakeList;
    Context mContext;
    interface Callback {
        void onItemClicked(int index, boolean longClick);

        void onIconClicked(int index);
    }

    public ListAdapter(Context context, List<Quake> items){
        mContext = context;
        quakeList = items;
    }

    @Override
    public void onBindViewHolder(QuakeViewHolder holder, int position) {
        try {
            setItemDetails(holder, quakeList.get(position));
        }catch (Exception e){

        }
    }

    public void setItemDetails(QuakeViewHolder holder, Quake quake){
        try{
            Properties properties = quake.getProperties();
            TextDrawable drawable = TextDrawable.builder()
                    .beginConfig().fontSize(50).bold().endConfig()
                    .buildRound(properties.getMag().toString(), Util.getColorCode(properties.getMag()));
            String title = properties.getPlace();
            String detail = Util.getDateString(properties.getTime());

            holder.icon.setImageDrawable(drawable);
            holder.title.setText(title);
            holder.detail.setText(detail);

        }catch(Exception e){

        }



    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        try{
            return quakeList.size();
        }catch(Exception e) {
            return 0;
        }
    }

    @Override
    public QuakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new QuakeViewHolder(v);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    class QuakeViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView title, detail;
        public ImageView icon;

        QuakeViewHolder(View itemView){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.name);
            detail = (TextView) itemView.findViewById(R.id.detail);
            icon = (ImageView) itemView.findViewById(R.id.list_image);
            view = itemView;
        }
    }
}
