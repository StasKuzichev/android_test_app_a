package com.rdc.androidtestappa.domain.test;

import android.content.ComponentName;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rdc.androidtestappa.Link;
import com.rdc.androidtestappa.R;
import com.rdc.androidtestappa.db.LinkDBHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFragment extends Fragment implements TestContract.View {
   private TestContract.Presenter testPresenter;

   private EditText inputLink;
   private Button buttonOk;
   private LinkDBHelper linkDBHelper;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonOk = view.findViewById(R.id.buttonOk);
        inputLink = view.findViewById(R.id.inputText);
        testPresenter = new TestPresenter();

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testPresenter.handleOkButtonClick(inputLink.getText().toString());
            }
        });
        testPresenter.setView(this);
    }

    @Override
    public void showEmptyFieldError() {
        Toast.makeText(getContext(), R.string.my_error, Toast.LENGTH_SHORT).show();
        inputLink.setText("");
    }

    @Override
    public void showWrongUrlFormatError() {
        Toast.makeText(getContext(), R.string.format, Toast.LENGTH_SHORT).show();
        inputLink.setText("");
    }

    @Override
    public void savePerson(String url, int status, String date) {

    }

    public void transmitToAppB(String url) {
        Intent intentURL = new Intent();
        intentURL.setComponent(new ComponentName("com.rdc.android_test_app_b",
                "com.rdc.android_test_app_b.domain.main.MainActivity"));
        intentURL.putExtra("url", url);
        intentURL.putExtra("bool", true);
        intentURL.putExtra("type", "edit");
        intentURL.putExtra("idLink", "0");
        startActivity(intentURL);
        inputLink.setText("");
    }





    }

