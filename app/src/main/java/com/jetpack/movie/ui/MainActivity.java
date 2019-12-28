package com.jetpack.movie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.jetpack.movie.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TabLayout tab = findViewById(R.id.tab);
        ViewPager vp = findViewById(R.id.vp);

        toolbar.setTitle(R.string.app_name);
        vp.setAdapter(new TabPagerAdapter(getSupportFragmentManager(), this));
        tab.setupWithViewPager(vp);
    }

}
