package com.rdc.androidtestappa;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class SecondTab extends Fragment implements ItemClickListener{
    private ArrayList<Link> links = new ArrayList<>();
    DataAdapter adapter;
    public static final String TAB_NAME = "history";

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
        View rootView = inflater.inflate(R.layout.second_tab_layout, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        setInitialData();
        adapter = new DataAdapter(getActivity(), links);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sortByDate) {
            sort(true);
            return true;
        }
        if (id == R.id.action_sortByStatus) {
            sort(false);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void setInitialData() {

        links.add(new Link(1, "https://ru.stackoverflow.com/questions/470518/%D0%92-%D1%82%D0%B5%D0%BA%D1%81%D1%82-%D0%B2-textview-%D0%BF%D0%BE-%D1%83%D0%BC%D0%BE%D0%BB%D1%87%D0%B0%D0%BD%D0%B8%D1%8E-%D0%B8%D0%B4%D0%B5%D1%82-%D0%B2%D1%8B%D1%80%D0%B0%D0%B2%D0%BD%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%82%D0%B5%D0%BA%D1%81%D1%82%D0%B0-%D0%BF%D0%BE-%D0%BB%D0%B5%D0%B2%D0%BE%D0%BC%D1%83-%D0%BA%D1%80%D0%B0%D1%8E-%D0%9A%D0%B0%D0%BA-%D0%B2%D1%8B%D1%80", 0));
        links.add(new Link(2, "https://ru.stackoverflow.com/questions/470518/%D0%92-%D1%82%D0%B5%D0%BA%D1%81%D1%82-%D0%B2-textview-%D0%BF%D0%BE-%D1%83%D0%BC%D0%BE%D0%BB%D1%87%D0%B0%D0%BD%D0%B8%D1%8E-%D0%B8%D0%B4%D0%B5%D1%82-%D0%B2%D1%8B%D1%80%D0%B0%D0%B2%D0%BD%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D1%82%D0%B5%D0%BA%D1%81%D1%82%D0%B0-%D0%BF%D0%BE-%D0%BB%D0%B5%D0%B2%D0%BE%D0%BC%D1%83-%D0%BA%D1%80%D0%B0%D1%8E-%D0%9A%D0%B0%D0%BA-%D0%B2%D1%8B%D1%80", 2));
        links.add(new Link(3, "00000", 2));
        links.add(new Link(5, "google2", 1));
        links.add(new Link(6, "google3", 1));
        links.add(new Link(7, "google4", 0));
        links.add(new Link(8, "http://ptolmachev.ru/wp-content/uploads/2017/02/%D0%A1%D0%B8%D0%BC%D0%BF%D1%81%D0%BD%D1%8B.jpg", 0));

    }

    @Override
    public void onItemClick(int position) {
        Intent intentURL = new Intent();
        intentURL.setComponent(new ComponentName("com.rdc.android_test_app_b", "com.rdc.android_test_app_b.MainActivity"));
        intentURL.putExtra("url", links.get(position).getUrl());
        intentURL.putExtra("bool", true);
        intentURL.putExtra("type", TAB_NAME);
        startActivity(intentURL);

    }

    public void sort(boolean b) {
        Link[] linksArray = new Link[links.size()];
        linksArray = links.toArray(linksArray);
        if (b) {
            Arrays.sort(linksArray, new ComparatorByDate());

        } else {
            Arrays.sort(linksArray, new ComparatorByStatus());
        }
        links.clear();
        links.addAll(Arrays.asList(linksArray));
        adapter.notifyDataSetChanged();

    }
}

