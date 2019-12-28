package com.jetpack.movie.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.jetpack.movie.data.source.MovieAppRepository;

import java.util.List;

public class TVShowViewModel extends ViewModel {
    private MovieAppRepository movieAppRepository;

    public TVShowViewModel(MovieAppRepository movieAppRepository) {
        this.movieAppRepository = movieAppRepository;
    }

    public LiveData<List<TVShowModel>> getTVShow() {
        return movieAppRepository.getAllTVShows();
    }
}
