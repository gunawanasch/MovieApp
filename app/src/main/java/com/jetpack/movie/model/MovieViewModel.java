package com.jetpack.movie.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.vo.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieAppRepository movieAppRepository;

    public MovieViewModel(MovieAppRepository movieAppRepository) {
        this.movieAppRepository = movieAppRepository;
    }

    public LiveData<Resource<List<MovieModel>>> getMovie() {
        return movieAppRepository.getAllMovies();
    }

}