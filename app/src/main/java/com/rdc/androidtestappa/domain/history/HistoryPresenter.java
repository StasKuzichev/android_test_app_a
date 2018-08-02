package com.rdc.androidtestappa.domain.history;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.RecyclerView;

import com.rdc.androidtestappa.Link;
import com.rdc.androidtestappa.db.LinkDBHelper;
import com.rdc.androidtestappa.utils.ComparatorByDate;
import com.rdc.androidtestappa.utils.ComparatorByStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HistoryPresenter implements HistoryContract.Presenter {

    private HistoryContract.View view;
    public List<Link> links;
    LinkDBHelper linkDBHelper;
    LinksAdapter linksAdapter;
    private List<Link> newLinks;
    private RecyclerView recyclerView;

    @Override
    public void setView(HistoryContract.View view) {
        this.view = view;
        links = new ArrayList<>();
        view.setHistory(links);
    }

    public void sort(boolean b, Context context) {
        linkDBHelper = new LinkDBHelper(context);
        linksAdapter = new LinksAdapter(linkDBHelper.linksList(""), context, recyclerView);
        newLinks = linkDBHelper.linksList("");
        if (b) {
            Collections.sort(newLinks, new ComparatorByDate());
        } else {
            Collections.sort(newLinks, new ComparatorByStatus());
        }

        view.setHistory(newLinks);
    }
}
