package com.jetpack.movie.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.jetpack.movie.data.source.MovieAppRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieAppRepository movieAppRepository;

    public MovieViewModel(MovieAppRepository movieAppRepository) {
        this.movieAppRepository = movieAppRepository;
    }

    public LiveData<List<MovieModel>> getMovie() {
        return movieAppRepository.getAllMovies();
    }
}