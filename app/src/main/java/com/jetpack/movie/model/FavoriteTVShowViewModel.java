package com.jetpack.movie.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.vo.Resource;

public class FavoriteTVShowViewModel extends ViewModel {
    private MovieAppRepository movieAppRepository;

    public FavoriteTVShowViewModel(MovieAppRepository movieAppRepository) {
        this.movieAppRepository = movieAppRepository;
    }

    public LiveData<Resource<PagedList<FavoriteTVShowModel>>> getFavoriteTVShowAsPaged() {
        return movieAppRepository.getFavoriteTVShowAsPaged();
    }

    public void deleteFavoriteTVShow(String id) {
        movieAppRepository.deleteFavoriteTVShow(id);
    }

}
