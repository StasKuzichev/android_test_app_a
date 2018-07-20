package com.rdc.androidtestappa;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstTab extends Fragment {
    TextView text;
    EditText inputLink;
    Button btnOk;
    String href;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab_first, container, false);
        btnOk = rootView.findViewById(R.id.buttonOk);
        inputLink = rootView.findViewById(R.id.inputText);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                href = inputLink.getText().toString();

                if (inputLink.getText().toString().isEmpty() || href.trim().length() == 0){//FULL EMPTYNESS
                    Toast.makeText(getContext(), R.string.my_error, Toast.LENGTH_SHORT).show();
                    inputLink.setText("");

                } else if (URLUtil.isValidUrl(href)) {
                    Intent intentURL = new Intent();
                    intentURL.setComponent(new ComponentName("com.rdc.android_test_app_b", "com.rdc.android_test_app_b.MainActivity"));
                    intentURL.putExtra("url", href);
                    intentURL.putExtra("bool", true);
                    startActivity(intentURL);
                    inputLink.setText("");

                } else if (!URLUtil.isValidUrl(href)) {
                    Toast.makeText(getContext(), R.string.format, Toast.LENGTH_SHORT).show();
                    inputLink.setText("");

                }
            }
        });
        return rootView;
    }

}

