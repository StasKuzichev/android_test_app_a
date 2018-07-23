package com.rdc.androidtestappa.domain.history;


public interface HistoryContract {
    interface View {
        void transmitToAppB(int position);

        void onItemClick(int position);
    }

    interface Presenter {
        void setInitialData();

        void sort(boolean b);

    }
}
