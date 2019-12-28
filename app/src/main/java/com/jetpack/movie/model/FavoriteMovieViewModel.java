package com.jetpack.movie.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.vo.Resource;

public class FavoriteMovieViewModel extends ViewModel {
    private MovieAppRepository movieAppRepository;

    public FavoriteMovieViewModel(MovieAppRepository movieAppRepository) {
        this.movieAppRepository = movieAppRepository;
    }

    public LiveData<Resource<PagedList<FavoriteMovieModel>>> getFavoriteMovieAsPaged() {
        return movieAppRepository.getFavoriteMovieAsPaged();
    }

    public void deleteFavoriteMovie(String id) {
        movieAppRepository.deleteFavoriteMovie(id);
    }

}
