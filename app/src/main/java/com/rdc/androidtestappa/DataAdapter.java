package com.rdc.androidtestappa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Link> links;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

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
        holder.urlText.setText(link.getUrlLink());
        holder.dateText.setText(simpleDateFormat.format(link.getDateLink()));
    }

    @Override
    public int getItemCount() {
        return links.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView urlText, dateText;
        ViewHolder(View view){
            super(view);
            urlText = (TextView) view.findViewById(R.id.url);
            dateText = (TextView) view.findViewById(R.id.date);
        }
    }
}
