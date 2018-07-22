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
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class SecondTab extends Fragment implements ItemClickListener{
    private ArrayList<Link> links = new ArrayList<>();
    DataAdapter adapter;

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
            Link[] linksArray = new Link[links.size()];
            linksArray = links.toArray(linksArray);
            Arrays.sort(linksArray,new ComparatorByDate());
            links.clear();
            links.addAll(Arrays.asList(linksArray));
            adapter.notifyDataSetChanged();
            return true;
        }
        if (id == R.id.action_sortByStatus) {
            Link[] linksArray = new Link[links.size()];
            linksArray = links.toArray(linksArray);
            Arrays.sort(linksArray,new ComparatorByStatus());
            links.clear();
            links.addAll(Arrays.asList(linksArray));
            adapter.notifyDataSetChanged();
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

        links.add(new Link(1, "11111", 0));
        links.add(new Link(2, "22222", 2));
        links.add(new Link(3, "00000",2));
        links.add(new Link(5, "google2", 1));
        links.add(new Link(6, "google3", 1));
        links.add(new Link(7, "google4", 0));
        links.add(new Link(8, "http://ptolmachev.ru/wp-content/uploads/2017/02/%D0%A1%D0%B8%D0%BC%D0%BF%D1%81%D0%BD%D1%8B.jpg", 0));

    }



    @Override
    public void onItemClick(int position) {
        Intent intentURL = new Intent();
        intentURL.setComponent(new ComponentName("com.rdc.android_test_app_b", "com.rdc.android_test_app_b.MainActivity"));
        intentURL.putExtra("url_from_A", links.get(position).getUrl());
        intentURL.putExtra("bool", true);
        startActivity(intentURL);

    }
}

