package com.jetpack.movie.ui;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jetpack.movie.R;

public class TabPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    @SuppressWarnings("deprecation")
    public TabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new MovieFragment();
            case 1 : return new TVShowFragment();
            case 2 : return new FavoriteMovieFragment();
            case 3 : return new FavoriteTVShowFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.title_tab_movie);
            case 1:
                return context.getString(R.string.title_tab_tv_show);
            case 2:
                return context.getString(R.string.title_tab_favorite_movie);
            case 3:
                return context.getString(R.string.title_tab_favorite_tv_show);
        }
        return null;
    }

}
