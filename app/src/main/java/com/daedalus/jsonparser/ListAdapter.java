package com.daedalus.jsonparser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Daedalus on 1/15/19.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.mViewHolder> {
    private Context m_context;
    private ArrayList<Destination> m_destinations;

    public ListAdapter(Context context, ArrayList<Destination> destinations){
        m_context = context;
        m_destinations = destinations;
    }

    public class mViewHolder extends RecyclerView.ViewHolder{
        TextView name_text;
        TextView location_text;
        TextView endDate_text;
        ImageButton imageButton;

        public mViewHolder(View itemView) {
            super(itemView);
            name_text = (TextView) itemView.findViewById(R.id.name_text);
            location_text = (TextView) itemView.findViewById(R.id.location_text);
            endDate_text = (TextView) itemView.findViewById(R.id.endDate_text);
            imageButton = (ImageButton) itemView.findViewById(R.id.imageButton);
        }
    }

    @Override
    //create views
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        mViewHolder view_holder = new mViewHolder(view);
        return view_holder;
    }

    //change content of views
    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        holder.name_text.setText(m_destinations.get(position).getName());
        String tempLocation = m_destinations.get(position).getCity() + ", " + m_destinations.get(position).getState();
        holder.location_text.setText(tempLocation);
        holder.endDate_text.setText(m_destinations.get(position).getEndDate());
        String url = m_destinations.get(position).getImageUrl();
        //library to load images from a url easily
        Picasso.get().load(url).into(holder.imageButton);

    }

    @Override
    public int getItemCount() {
        return m_destinations.size();
    }
}
