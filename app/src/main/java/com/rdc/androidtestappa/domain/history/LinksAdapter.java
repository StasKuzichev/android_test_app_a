package com.rdc.androidtestappa.domain.history;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rdc.androidtestappa.data.models.Link;
import com.rdc.androidtestappa.R;

import java.util.List;

public class LinksAdapter extends RecyclerView.Adapter<LinksAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Link> links;
    private String check;
    private ItemClickListener itemClickListener;
    private Context context;
    private RecyclerView recyclerView;

    public LinksAdapter(Context context, List<Link> links) {
        this.context = context;
        this.links = links;
    }

    public LinksAdapter(List<Link> links, Context context, RecyclerView recyclerView) {
        this.inflater = LayoutInflater.from(context);
        this.links = links;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @Override
    public LinksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.link_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(LinksAdapter.ViewHolder holder, int position) {
        Link link = links.get(position);
        if (link.getUrl().length() > 48) {
            check = link.getUrl().substring(0, 48) + "...";
        } else {
            check = link.getUrl();
        }
        holder.urlText.setText(check);
        holder.dateText.setText(link.getDate());
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
            if (itemClickListener != null) {
                itemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }

    public void setListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    public void setNewData(List<Link> newData) {
        links = newData;
        notifyDataSetChanged();
    }

}
