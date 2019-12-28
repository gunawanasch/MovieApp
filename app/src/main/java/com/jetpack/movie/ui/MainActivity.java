package com.jetpack.movie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.jetpack.movie.R;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabMain;
    private ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabMain = (TabLayout) findViewById(R.id.tabMain);
        vpMain = (ViewPager) findViewById(R.id.vpMain);

        setSupportActionBar(toolbar);
        vpMain.setAdapter(new TabPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));
        tabMain.setupWithViewPager(vpMain);
    }
}
