package com.rdc.androidtestappa.domain.history;

import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rdc.androidtestappa.Link;
import com.rdc.androidtestappa.R;

import java.text.SimpleDateFormat;

public class LinksAdapterBase extends BaseQuickAdapter<Link, BaseViewHolder> implements View.OnClickListener {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private final OnLinkClickListener onLinkClickListener;

    LinksAdapterBase(@NonNull OnLinkClickListener onLinkClickListener) {
        super(R.layout.list_item);
        this.onLinkClickListener = onLinkClickListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, Link item) {
        helper.setText(R.id.url, item.getUrl().length() > 48 ? item.getUrl().substring(0, 48) + "..." : item.getUrl())
                .setText(R.id.date, simpleDateFormat.format(item.getDate()))
                .setBackgroundColor(R.id.linear_layout, item.getStatusColor());
        helper.itemView.setTag(helper.getAdapterPosition());
        helper.itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onLinkClickListener.onLinkClicked(getItem((int) view.getTag()));
    }

    public interface OnLinkClickListener {
        void onLinkClicked(Link link);
    }
}
