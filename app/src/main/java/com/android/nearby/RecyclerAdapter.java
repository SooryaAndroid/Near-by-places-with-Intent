package com.android.nearby;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arunkumar on 07/03/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    ArrayList<String>places;
    MainActivity mainActivity;

    public RecyclerAdapter(ArrayList<String>places, MainActivity mainActivity) {
        this.places = places;
        this.mainActivity = mainActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.places.setText(places.get(position));
        holder.cardView.setOnClickListener(Details(position,holder));

    }

    public View.OnClickListener Details(final int postion, final ViewHolder holder)
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.location_fetch(postion);

            }
        };
    }


    @Override
    public int getItemCount() {
        return places.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView places;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            places = (TextView)itemView.findViewById(R.id.txt_places);
            cardView = (CardView)itemView.findViewById(R.id.cardview);

        }
    }
}
