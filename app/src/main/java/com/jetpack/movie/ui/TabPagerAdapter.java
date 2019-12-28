package com.jetpack.movie.ui;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {
    private int totalTab = 2;
    private String[] tabTitles = new String[]{"Popular Movie", "Popular TV Show"};
    private Context context;

    @SuppressWarnings("deprecation")
    public TabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return totalTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new MovieFragment();
            case 1 : return new TVShowFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
