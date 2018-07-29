package com.rdc.androidtestappa.domain.test;

public interface TestContract {
    interface View {
        void transmitToAppB(String url);

        void showEmptyFieldError();

        void showWrongUrlFormatError();

        void savePerson(String url, int status, String date);
    }

    interface Presenter {
        void handleOkButtonClick(String url);

        void setView(TestContract.View view);
    }
}
