package com.rdc.androidtestappa.domain;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rdc.androidtestappa.domain.history.HistoryTab;
import com.rdc.androidtestappa.domain.test.TestTab;

public class SectionPageAdapter extends FragmentPagerAdapter {

    public SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TestTab testTab = new TestTab();
                return testTab;
            case 1:
                HistoryTab historyTab = new HistoryTab();
                return historyTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
