package com.jetpack.movie.ui;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jetpack.movie.R;
import com.jetpack.movie.model.DetailViewModel;
import com.jetpack.movie.model.FavoriteMovieModel;
import com.jetpack.movie.model.FavoriteMovieViewModel;
import com.jetpack.movie.model.FavoriteTVShowModel;
import com.jetpack.movie.model.FavoriteTVShowViewModel;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;
import com.jetpack.movie.model.ViewModelFactory;
import com.jetpack.movie.utils.ConvertDate;

public class DetailActivity extends AppCompatActivity {
    public static final String OBJECT = "object";
    public static final String TAB_PAGE = "tab";
    private ImageView ivFavorite;
    private ViewModelFactory factory;
    private DetailViewModel viewModel;
    private MovieModel movie;
    private TVShowModel tvShow;

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
        ivFavorite = findViewById(R.id.ivFavorite);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> onBackPressed());
        }

        pb.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

        factory = ViewModelFactory.getInstance(DetailActivity.this.getApplication());
        viewModel = ViewModelProviders.of(this, factory).get(DetailViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String tabPage = extras.getString(TAB_PAGE);
            if (Integer.parseInt(tabPage) == 0) {
                movie = (MovieModel) extras.getSerializable(OBJECT);
                viewModel.getDetailMovie(movie.getMovieId()).observe(this, result -> {
                    if (viewModel.getDetailMovie(movie.getMovieId()) != null) {
                        switch (result.status) {
                            case LOADING:
                                pb.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                pb.setVisibility(View.GONE);
                                scrollView.setVisibility(View.VISIBLE);
                                tvTitle.setText(result.data.getName());
                                tvRating.setText(String.valueOf(result.data.getRating()));
                                tvReleaseDate.setText(new ConvertDate().newFormatDate(result.data.getReleaseDate()));
                                tvLanguage.setText(result.data.getLanguage());
                                tvOverview.setText(result.data.getOverview());
                                Glide.with(getApplicationContext())
                                        .load("https://image.tmdb.org/t/p/w500/"+result.data.getPoster())
                                        .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                                        .into(ivPhoto);
                                viewModel.getFavoriteMovieById(movie.getMovieId()).observe(this, favoriteMovieObserver);
                                break;
                            case ERROR:
                                pb.setVisibility(View.GONE);
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            } else {
                tvShow = (TVShowModel) extras.getSerializable(OBJECT);
                viewModel.getDetailTVShow(tvShow.getTvId()).observe(this, data -> {
                    if (viewModel.getDetailTVShow(tvShow.getTvId()) != null) {
                        switch (data.status) {
                            case LOADING:
                                pb.setVisibility(View.VISIBLE);
                                break;
                            case SUCCESS:
                                pb.setVisibility(View.GONE);
                                scrollView.setVisibility(View.VISIBLE);
                                tvTitle.setText(data.data.getName());
                                tvRating.setText(String.valueOf(data.data.getRating()));
                                tvReleaseDate.setText(new ConvertDate().newFormatDate(data.data.getReleaseDate()));
                                tvLanguage.setText(data.data.getLanguage());
                                tvOverview.setText(data.data.getOverview());
                                Glide.with(getApplicationContext())
                                        .load("https://image.tmdb.org/t/p/w500/"+data.data.getPoster())
                                        .apply(RequestOptions.placeholderOf(R.drawable.ic_image).error(R.drawable.ic_broken_image))
                                        .into(ivPhoto);
                                viewModel.getFavoriteTVShowById(tvShow.getTvId()).observe(this, favoriteTVShowObserver);
                                break;
                            case ERROR:
                                pb.setVisibility(View.GONE);
                                Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
            }
        }
    }

    private final Observer<FavoriteMovieModel> favoriteMovieObserver = new Observer<FavoriteMovieModel>() {
        @Override
        public void onChanged(@Nullable FavoriteMovieModel favoriteMovie) {
            if (favoriteMovie != null) {
                ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.red)));
                ivFavorite.setClickable(false);
            } else {
                ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.white)));
                ivFavorite.setClickable(true);
                ivFavorite.setOnClickListener(v -> {
                    FavoriteMovieViewModel fmViewModel = ViewModelProviders.of(DetailActivity.this, factory).get(FavoriteMovieViewModel.class);
                    fmViewModel.getFavoriteMovieAsPaged().observe(DetailActivity.this, result -> {
                        if (result != null) {
                            switch (result.status) {
                                case LOADING:
                                    ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.white)));
                                    break;
                                case SUCCESS:
                                    if (result.data.size() < 10) {
                                        ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.red)));
                                        viewModel.setFavoriteMovie(movie);
                                    } else {
                                        ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.white)));
                                        Toast.makeText(DetailActivity.this, "Data favorit sudah 10, jika ingin menambahkan lagi harap hapus data favorit yang sudah ada", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case ERROR:
                                    ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.white)));
                                    Toast.makeText(DetailActivity.this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });
                });
            }
        }
    };

    private final Observer<FavoriteTVShowModel> favoriteTVShowObserver = new Observer<FavoriteTVShowModel>() {
        @Override
        public void onChanged(@Nullable FavoriteTVShowModel favoriteTVShow) {
            if (favoriteTVShow != null) {
                ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.red)));
                ivFavorite.setClickable(false);
            } else {
                ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.white)));
                ivFavorite.setClickable(true);
                ivFavorite.setOnClickListener(v -> {
                    FavoriteTVShowViewModel ftViewModel = ViewModelProviders.of(DetailActivity.this, factory).get(FavoriteTVShowViewModel.class);
                    ftViewModel.getFavoriteTVShowAsPaged().observe(DetailActivity.this, result -> {
                        if (result != null) {
                            switch (result.status) {
                                case LOADING:
                                    ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.white)));
                                    break;
                                case SUCCESS:
                                    if (result.data.size() < 10) {
                                        ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.red)));
                                        viewModel.setFavoriteTvShow(tvShow);
                                    } else {
                                        ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.white)));
                                        Toast.makeText(DetailActivity.this, "Data favorit sudah 10, jika ingin menambahkan lagi harap hapus data favorit yang sudah ada", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case ERROR:
                                    ImageViewCompat.setImageTintList(ivFavorite, ColorStateList.valueOf(ContextCompat.getColor(DetailActivity.this, R.color.white)));
                                    Toast.makeText(DetailActivity.this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });
                });
            }
        }
    };

}
