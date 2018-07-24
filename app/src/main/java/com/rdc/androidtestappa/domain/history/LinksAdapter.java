package com.rdc.androidtestappa.domain.history;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rdc.androidtestappa.Link;
import com.rdc.androidtestappa.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LinksAdapter extends RecyclerView.Adapter<LinksAdapter.ViewHolder> implements View.OnClickListener {
    private LayoutInflater inflater;
    private List<Link> links;
    private String check;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private OnLinkClickListener mClickListener;

    public LinksAdapter(Context context) {
        this.links = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
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
        holder.dateText.setText(simpleDateFormat.format(link.getDate()));
        holder.rowLinearLayout.setBackgroundColor(link.getStatusColor());
    }

    @Override
    public int getItemCount() {
        return links.size();
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        if(mClickListener==null)return;
        mClickListener.onLinkClicked(links.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView urlText, dateText;
        LinearLayout rowLinearLayout;

        ViewHolder(View view) {
            super(view);
            urlText = (TextView) view.findViewById(R.id.url);
            dateText = (TextView) view.findViewById(R.id.date);
            rowLinearLayout = (LinearLayout) view.findViewById(R.id.linear_layout);
            itemView.setTag(getAdapterPosition());
            itemView.setOnClickListener(LinksAdapter.this);
        }
    }

    public void setNewData(List<Link> newData) {
        links = newData;
        notifyDataSetChanged();
    }

    public void setListener(OnLinkClickListener itemClickListener) {
        mClickListener = itemClickListener;
    }

    public interface OnLinkClickListener{
        void onLinkClicked(Link link);
    }
}
