package com.rdc.androidtestappa.domain.test;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rdc.androidtestappa.R;

public class TestPresenter implements TestContract.Presenter {

    private TestContract.View view;

    @Override
    public void setView(TestContract.View view) {
        this.view = view;
    }

    public void handleOkButtonClick( String url) {
        url = url.trim();
        if (TextUtils.isEmpty(url)) {
            view.showEmptyFieldError();
        } else if (URLUtil.isValidUrl(url)) {
            view.transmitToAppB(url);
        } else {
            view.showWrongUrlFormatError();
        }
    }


}
