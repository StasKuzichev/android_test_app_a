package com.rdc.androidtestappa.domain.history;

import android.content.Context;

import com.rdc.androidtestappa.Link;
import java.util.List;

public interface HistoryContract {
    interface View {
        void setHistory(List<Link > links);
    }

    interface Presenter {
        void setView(HistoryContract.View view);

        void sort(boolean b, Context context);

    }
}
