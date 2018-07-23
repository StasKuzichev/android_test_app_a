package com.rdc.androidtestappa.domain.test;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rdc.androidtestappa.R;

public class TestTab extends Fragment implements TestContract.View {
    TestPresenter testPresenter;
    TextView text;
    EditText inputLink;
    Button buttonOk;
    String url;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.test_tab, container, false);
        buttonOk = rootView.findViewById(R.id.buttonOk);
        inputLink = rootView.findViewById(R.id.inputText);
        testPresenter = new TestPresenter();

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testPresenter.handleOkButtonClick(text, inputLink, buttonOk, url);
            }
        });
        return rootView;
    }

    public void transmitToAppB(String url, EditText inputLink) {
        Intent intentURL = new Intent();
        intentURL.setComponent(new ComponentName("com.rdc.android_test_app_b",
                "com.rdc.android_test_app_b.MainActivity"));
        intentURL.putExtra("url", url);
        intentURL.putExtra("bool", true);
        startActivity(intentURL);
        inputLink.setText("");
    }


}


