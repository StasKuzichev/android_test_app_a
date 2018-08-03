package com.rdc.androidtestappa.domain.history;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.rdc.androidtestappa.data.models.Link;
import com.rdc.androidtestappa.R;
import com.rdc.androidtestappa.data.db.LinkDBHelper;

import java.util.List;

public class HistoryFragment extends Fragment implements HistoryContract.View, ItemClickListener {
    private LinksAdapter linksAdapter;
    private HistoryContract.Presenter historyPresenter;
    private LinkDBHelper linkDBHelper;
    private RecyclerView recyclerView;
    private String filter = "";
    private List<Link> newLinks;

    @Override
    public void onResume() {
        super.onResume();
        populateRecyclerView(filter);
    }

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

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();

        historyPresenter = new HistoryPresenter();
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);

        linksAdapter = new LinksAdapter(getContext(), new HistoryPresenter().links);
        linksAdapter.setListener(this);
        recyclerView.setAdapter(linksAdapter);

        historyPresenter.setView(this);
        populateRecyclerView(filter);

        final SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.pullToRefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                populateRecyclerView(filter);
                pullToRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void populateRecyclerView(String filter) {
        linkDBHelper = new LinkDBHelper(getContext());
        linksAdapter = new LinksAdapter(linkDBHelper.linksList(filter), getContext(), recyclerView);
        linksAdapter.setListener(this);
        recyclerView.setAdapter(linksAdapter);
        newLinks = linkDBHelper.linksList(filter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sortByDate:
                historyPresenter.sort(true, getContext());
                return true;
            case R.id.action_sortByStatus:
                historyPresenter.sort(false, getContext());
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
        linkDBHelper = new LinkDBHelper(getContext());
        linksAdapter = new LinksAdapter(linkDBHelper.linksList(filter), getContext(), recyclerView);
        linksAdapter.setListener(this);
        recyclerView.setAdapter(linksAdapter);
        newLinks = links;
        linksAdapter.setNewData(links);
    }

    @Override
    public void onItemClick(int position) {
        Link link = newLinks.get(position);
        long id = link.getId();
        String str = String.valueOf(id);
        String url = link.getUrl();
        Intent intentURL = new Intent();
        intentURL.setComponent(new ComponentName(
                "com.rdc.android_test_app_b",
                "com.rdc.android_test_app_b.domain.main.MainActivity"));
        intentURL.putExtra("url", url);
        intentURL.putExtra("bool", true);
        intentURL.putExtra("type", "history");
        intentURL.putExtra("idLink", str);
        intentURL.putExtra("status", link.getStatus());
        startActivity(intentURL);

    }

}
