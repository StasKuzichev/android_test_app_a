package com.rdc.androidtestappa.domain.test;

import android.support.v4.app.Fragment;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rdc.androidtestappa.R;

public class TestPresenter extends Fragment implements TestContract.Presenter {
    TestTab testTab = new TestTab();

    public void handleOkButtonClick(TextView text, EditText inputLink, Button buttonOk, String url) {

        url = inputLink.getText().toString();

        if (inputLink.getText().toString().isEmpty() || url.trim().length() == 0) {

            Toast.makeText(getContext(), R.string.my_error, Toast.LENGTH_SHORT).show();
            inputLink.setText("");

        } else if (URLUtil.isValidUrl(url)) {

            testTab.transmitToAppB(url, inputLink);

        } else {

            Toast.makeText(getContext(), R.string.format, Toast.LENGTH_SHORT).show();
            inputLink.setText("");

        }
    }


}
