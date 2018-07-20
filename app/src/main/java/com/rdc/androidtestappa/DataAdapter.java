package com.rdc.androidtestappa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Link> links;

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
        holder.url.setText(link.getUrlLink());
        holder.date.setText((link.getDateLink()).toString());
    }

    @Override
    public int getItemCount() {
        return links.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView url, date;
        ViewHolder(View view){
            super(view);
            url = (TextView) view.findViewById(R.id.url);
            date = (TextView) view.findViewById(R.id.date);
        }
    }
}
