package com.rdc.androidtestappa;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A placeholder fragment containing a simple view.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FirstTab firstTab = new FirstTab();
                return firstTab;
            case 1:
                SecondTab secondTab = new SecondTab();
                return secondTab;
            default :
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


}