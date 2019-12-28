package com.jetpack.movie.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.jetpack.movie.data.source.MovieAppRepository;

public class DetailViewModel extends ViewModel {
    private MovieAppRepository movieAppRepository;

    public DetailViewModel(MovieAppRepository movieAppRepository) {
        this.movieAppRepository = movieAppRepository;
    }

    public LiveData<MovieModel> getDetailMovie(String id) {
        return movieAppRepository.getDetailMovie(id);
    }

    public LiveData<TVShowModel> getDetailTVShow(String id) {
        return movieAppRepository.getDetailTVShow(id);
    }

}
