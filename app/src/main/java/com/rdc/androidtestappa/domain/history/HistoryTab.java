package com.rdc.androidtestappa.domain.history;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;

public class HistoryTab extends Fragment implements ItemClickListener,HistoryContract.View {
    ArrayList<Link> links = new ArrayList<>();
    DataAdapter adapter;
    private HistoryPresenter historyPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.history_tab, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        historyPresenter = new HistoryPresenter();
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        historyPresenter.setInitialData();
        adapter = new DataAdapter(getActivity(), links);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sortByDate) {
            historyPresenter.sort(true);
            return true;
        }
        if (id == R.id.action_sortByStatus) {
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

    public void onItemClick(int position) {
        transmitToAppB(position);
    }

    public void transmitToAppB(int position) {
        Intent intentURL = new Intent();
        intentURL.setComponent(new ComponentName("com.rdc.android_test_app_b", "com.rdc.android_test_app_b.MainActivity"));
        intentURL.putExtra("url_from_A", links.get(position).getUrl());
        intentURL.putExtra("bool", true);
        startActivity(intentURL);
    }
}
