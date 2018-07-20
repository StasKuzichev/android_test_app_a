package com.rdc.androidtestappa;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstTab extends Fragment {
    EditText textURL;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_first, container, false);
        Button buttonURL = rootView.findViewById(R.id.buttonOK);
        textURL = rootView.findViewById(R.id.editText);
        buttonURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentURL = new Intent();
                intentURL.setComponent(new ComponentName("com.rdc.android_test_app_b", "com.rdc.android_test_app_b.MainActivity"));
                intentURL.putExtra("url", textURL.getText().toString());
                intentURL.putExtra("bool", true);
                startActivity(intentURL);
            }
        });
        return rootView;
    }
}
