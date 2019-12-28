package com.jetpack.movie.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.vo.Resource;

import java.util.List;

public class TVShowViewModel extends ViewModel {
    private MovieAppRepository movieAppRepository;

    public TVShowViewModel(MovieAppRepository movieAppRepository) {
        this.movieAppRepository = movieAppRepository;
    }

    public LiveData<Resource<List<TVShowModel>>> getTVShow() {
        return movieAppRepository.getAllTVShows();
    }

}
