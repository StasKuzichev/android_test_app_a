package com.rdc.androidtestappa.domain;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rdc.androidtestappa.domain.history.HistoryFragment;
import com.rdc.androidtestappa.domain.test.TestFragment;

public class SectionPageAdapter extends FragmentPagerAdapter {

    SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TestFragment();
            case 1:
                return  new HistoryFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
