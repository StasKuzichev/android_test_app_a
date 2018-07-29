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
        Date thisDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String date = simpleDateFormat.format(thisDate).toString();

        links = new ArrayList<>();

        links.add(new Link("https://ru.stackoverflow.com/questions/470518/%D0%92-%D1%82%D0%B5%D0%BA%D1%81%D1%82-%D0%B2-textview-%D0%BF%D0%BE-%D1%83%D0%BC%D0%BE%D0%BB%D1%87%D0%B0%D0%BD%D0%B8%D1%8E-%D0%B8%D0%B4%D0%B5%D1%82-%D0%B2%D1%8B%D1%80%D0%B0%D0%B2%D0%BD%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%82%D0%B5%D0%BA%D1%81%D1%82%D0%B0-%D0%BF%D0%BE-%D0%BB%D0%B5%D0%B2%D0%BE%D0%BC%D1%83-%D0%BA%D1%80%D0%B0%D1%8E-%D0%9A%D0%B0%D0%BA-%D0%B2%D1%8B%D1%80", 0, date));
        links.add(new Link("https://ru.stackoverflow.com/questions/470518/%D0%92-%D1%82%D0%B5%D0%BA%D1%81%D1%82-%D0%B2-textview-%D0%BF%D0%BE-%D1%83%D0%BC%D0%BE%D0%BB%D1%87%D0%B0%D0%BD%D0%B8%D1%8E-%D0%B8%D0%B4%D0%B5%D1%82-%D0%B2%D1%8B%D1%80%D0%B0%D0%B2%D0%BD%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%82%D0%B5%D0%BA%D1%81%D1%82%D0%B0-%D0%BF%D0%BE-%D0%BB%D0%B5%D0%B2%D0%BE%D0%BC%D1%83-%D0%BA%D1%80%D0%B0%D1%8E-%D0%9A%D0%B0%D0%BA-%D0%B2%D1%8B%D1%80", 2, date));
        links.add(new Link("00000", 2, date));
        links.add(new Link("http://ptolmachev.ru/wp-content/uploads/2017/02/%D0%A1%D0%B8%D0%BC%D0%BF%D1%81%D0%BD%D1%8B.jpg", 0, date));


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
