package com.jetpack.movie.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jetpack.movie.R;
import com.jetpack.movie.model.DetailViewModel;
import com.jetpack.movie.model.ViewModelFactory;
import com.jetpack.movie.utils.ConvertDate;

public class DetailActivity extends AppCompatActivity {
    public static final String ID_DATA = "id_data";
    public static final String TAB_PAGE = "tab";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ProgressBar pb = findViewById(R.id.pb);
        ScrollView scrollView = findViewById(R.id.scrollView);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvRating = findViewById(R.id.tvRating);
        TextView tvReleaseDate = findViewById(R.id.tvReleaseDate);
        TextView tvLanguage = findViewById(R.id.tvLanguage);
        TextView tvOverview = findViewById(R.id.tvOverview);
        ImageView ivPhoto = findViewById(R.id.ivPoster);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        pb.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

        ViewModelFactory factory = ViewModelFactory.getInstance();
        DetailViewModel viewModel = ViewModelProviders.of(this, factory).get(DetailViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String id = extras.getString(ID_DATA);
            String tabPage = extras.getString(TAB_PAGE);
            if (Integer.parseInt(tabPage) == 0) {
                viewModel.getDetailMovie(id).observe(this, data -> {
                    if (viewModel.getDetailMovie(id) != null) {
                        pb.setVisibility(View.GONE);
                        scrollView.setVisibility(View.VISIBLE);
                        tvTitle.setText(data.getName());
                        tvRating.setText(String.valueOf(data.getRating()));
                        tvReleaseDate.setText(new ConvertDate().newFormatDate(data.getReleaseDate()));
                        tvLanguage.setText(data.getLanguage());
                        tvOverview.setText(data.getOverview());
                        Glide.with(getApplicationContext())
                                .load("https://image.tmdb.org/t/p/w500/"+data.getPoster())
                                .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                                .into(ivPhoto);
                    }
                });
            } else {
                viewModel.getDetailTVShow(id).observe(this, data -> {
                    if (viewModel.getDetailTVShow(id) != null) {
                        pb.setVisibility(View.GONE);
                        scrollView.setVisibility(View.VISIBLE);
                        tvTitle.setText(data.getName());
                        tvRating.setText(String.valueOf(data.getRating()));
                        tvReleaseDate.setText(new ConvertDate().newFormatDate(data.getReleaseDate()));
                        tvLanguage.setText(data.getLanguage());
                        tvOverview.setText(data.getOverview());
                        Glide.with(getApplicationContext())
                                .load("https://image.tmdb.org/t/p/w500/"+data.getPoster())
                                .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                                .into(ivPhoto);
                    }
                });
            }
        }
    }
}
