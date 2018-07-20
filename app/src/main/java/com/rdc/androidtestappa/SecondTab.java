package com.rdc.androidtestappa;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SecondTab extends Fragment {
    ArrayList<Link> links = new ArrayList<>();

    //        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.second_tab_layout, container, false);
//            return rootView;
//        }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView =
                inflater.inflate(R.layout.second_tab_layout, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        setInitialData();
        DataAdapter adapter = new DataAdapter(getActivity(), links);
        recyclerView.setAdapter(adapter);

        return rootView;
    }


    private void setInitialData() {

        links.add(new Link(1, "google", 0));
        links.add(new Link(2, "google", 0));
        links.add(new Link(3, "google", 0));
        links.add(new Link(4, "google", 0));
        links.add(new Link(5, "google", 0));
        links.add(new Link(6, "google", 0));
        links.add(new Link(7, "google", 0));
        links.add(new Link(8, "google", 0));
        links.add(new Link(9, "google", 0));
        links.add(new Link(10, "google", 0));


    }

}