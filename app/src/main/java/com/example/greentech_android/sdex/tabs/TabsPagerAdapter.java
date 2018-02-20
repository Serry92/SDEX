package com.example.greentech_android.sdex.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.greentech_android.sdex.facebook.FriendListFragment;
import com.example.greentech_android.sdex.typicode.TypiCodeFragment;

/**
 * Created by GreenTech-Android on 2/20/2018.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new FriendListFragment();
            case 1:
                // Games fragment activity
                return new TypiCodeFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }

}
