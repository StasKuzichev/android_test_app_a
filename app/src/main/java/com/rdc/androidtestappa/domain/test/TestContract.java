package com.rdc.androidtestappa.domain.test;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public interface TestContract {
    interface View {
        void transmitToAppB(String url, EditText inputLink);
    }

    interface Presenter {
        void handleOkButtonClick(TextView text, EditText inputLink, Button buttonOk, String url);

    }
}
