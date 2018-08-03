package com.rdc.androidtestappa.domain.history;

import android.content.Context;

import com.rdc.androidtestappa.data.models.Link;
import com.rdc.androidtestappa.data.db.LinkDBHelper;
import com.rdc.androidtestappa.utils.ComparatorByDate;
import com.rdc.androidtestappa.utils.ComparatorByStatus;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoryPresenter implements HistoryContract.Presenter {

    private HistoryContract.View view;
    public List<Link> links;
    private LinkDBHelper linkDBHelper;
    private LinksAdapter linksAdapter;
    private List<Link> newLinks;

    @Override
    public void setView(HistoryContract.View view) {
        this.view = view;
        links = new ArrayList<>();
        view.setHistory(links);
    }

    @Override
    public void sort(boolean b, Context context) {
        linkDBHelper = new LinkDBHelper(context);
        linksAdapter = new LinksAdapter(context, linkDBHelper.linksList(""));
        newLinks = linkDBHelper.linksList("");
        if (b) {
            Collections.sort(newLinks, new ComparatorByDate());
        } else {
            Collections.sort(newLinks, new ComparatorByStatus());
        }
        view.setHistory(newLinks);
    }
}
