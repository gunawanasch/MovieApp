package com.jetpack.movie.data.source;

import androidx.lifecycle.LiveData;

import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;

import java.util.List;

public interface MovieAppDataSource {
    LiveData<List<MovieModel>> getAllMovies();
    LiveData<MovieModel> getDetailMovie(String id);
    LiveData<List<TVShowModel>> getAllTVShows();
    LiveData<TVShowModel> getDetailTVShow(String id);
}
