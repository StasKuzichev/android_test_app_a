package com.rdc.androidtestappa.domain.test;

public interface TestContract {
    interface View {
        void transmitToAppB(String url);

        void showEmptyFieldError();

        void showWrongUrlFormatError();

    }

    interface Presenter {
        void handleOkButtonClick(String url);

        void setView(TestContract.View view);
    }
}
