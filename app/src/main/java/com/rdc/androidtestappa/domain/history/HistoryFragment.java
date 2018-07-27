package com.rdc.androidtestappa.domain.history;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.rdc.androidtestappa.Link;
import com.rdc.androidtestappa.R;

import java.util.List;

public class HistoryFragment extends Fragment implements HistoryContract.View,
        LinksAdapterBase.OnLinkClickListener {
    private LinksAdapterBase adapter;
    private HistoryContract.Presenter historyPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        historyPresenter = new HistoryPresenter();
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        adapter = new LinksAdapterBase(this);
        recyclerView.setAdapter(adapter);

        historyPresenter.setView(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sortByDate:
                historyPresenter.sort(true);
                return true;
            case R.id.action_sortByStatus:
                historyPresenter.sort(false);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void setHistory(List<Link> links) {
        adapter.setNewData(links);
    }

    @Override
    public void onLinkClicked(Link link) {
        Intent intentURL = new Intent();
        intentURL.setComponent(new ComponentName(
                "com.rdc.android_test_app_b",
                "com.rdc.android_test_app_b.MainActivity")
        );
        intentURL.putExtra("url", link.getUrl());
        intentURL.putExtra("bool", true);
        intentURL.putExtra("type", "history");
        startActivity(intentURL);
    }
}
