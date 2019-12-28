package com.jetpack.movie.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jetpack.movie.R;
import com.jetpack.movie.model.DetailViewModel;

public class DetailActivity extends AppCompatActivity {
    public static final String ID_DATA = "id_data";
    public static final String TAB_PAGE = "tab";
    private Toolbar toolbar;
    private TextView tvTitle, tvRating, tvReleaseDate, tvLanguage, tvOverview;
    private ImageView ivPhoto;
    private DetailViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        tvRating = findViewById(R.id.tvRating);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);
        tvLanguage = findViewById(R.id.tvLanguage);
        tvOverview = findViewById(R.id.tvOverview);
        ivPhoto = findViewById(R.id.ivPoster);

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

        viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String id = extras.getString(ID_DATA);
            String tabPage = extras.getString(TAB_PAGE);
            if (Integer.parseInt(tabPage) == 0) {
                viewModel.setMovieId(id);
                if (viewModel.getMovie() != null) {
                    tvTitle.setText(viewModel.getMovie().getName());
                    tvRating.setText(String.valueOf(viewModel.getMovie().getRating()));
                    tvReleaseDate.setText(viewModel.getMovie().getReleaseDate());
                    tvLanguage.setText(viewModel.getMovie().getLanguage());
                    tvOverview.setText(String.valueOf(viewModel.getMovie().getOverview()));

                    Glide.with(getApplicationContext())
                            .load(viewModel.getMovie().getPoster())
                            .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                            .into(ivPhoto);
                }
            } else {
                viewModel.setTvId(id);
                if (viewModel.geTVShow() != null) {
                    tvTitle.setText(viewModel.geTVShow().getName());
                    tvRating.setText(String.valueOf(viewModel.geTVShow().getRating()));
                    tvReleaseDate.setText(viewModel.geTVShow().getReleaseDate());
                    tvLanguage.setText(viewModel.geTVShow().getLanguage());
                    tvOverview.setText(String.valueOf(viewModel.geTVShow().getOverview()));

                    Glide.with(getApplicationContext())
                            .load(viewModel.geTVShow().getPoster())
                            .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                            .into(ivPhoto);
                }
            }
        }
    }
}
