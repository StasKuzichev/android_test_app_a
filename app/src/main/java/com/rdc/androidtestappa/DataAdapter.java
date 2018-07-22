package com.rdc.androidtestappa;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Link> links;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private ItemClickListener mClickListener;

    DataAdapter(Context context, ArrayList<Link> links) {
        this.links = links;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Link link = links.get(position);
        holder.urlText.setText(link.getUrl());
        holder.dateText.setText(simpleDateFormat.format(link.getDate()));
        holder.rowLinearLayout.setBackgroundColor(link.getStatusColor());
    }

    @Override
    public int getItemCount() {
        return links.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView urlText, dateText;
        LinearLayout rowLinearLayout;
        ViewHolder(View view){
            super(view);
            urlText = (TextView) view.findViewById(R.id.url);
            dateText = (TextView) view.findViewById(R.id.date);
            rowLinearLayout = (LinearLayout) view.findViewById(R.id.linear_layout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(getAdapterPosition());
            }
        }


    }

    public void setListener(ItemClickListener itemClickListener) {
        mClickListener = itemClickListener;
    }
}
