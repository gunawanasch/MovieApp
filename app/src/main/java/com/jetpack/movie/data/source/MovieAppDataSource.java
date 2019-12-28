package com.jetpack.movie.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.jetpack.movie.model.DetailMovieModel;
import com.jetpack.movie.model.DetailTVShowModel;
import com.jetpack.movie.model.FavoriteMovieModel;
import com.jetpack.movie.model.FavoriteTVShowModel;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;
import com.jetpack.movie.vo.Resource;

import java.util.List;

public interface MovieAppDataSource {
    LiveData<Resource<List<MovieModel>>> getAllMovies();
    LiveData<Resource<DetailMovieModel>> getDetailMovie(String id);
    LiveData<Resource<List<TVShowModel>>> getAllTVShows();
    LiveData<Resource<DetailTVShowModel>> getDetailTVShow(String id);
    LiveData<Resource<PagedList<FavoriteMovieModel>>> getFavoriteMovieAsPaged();
    LiveData<Resource<PagedList<FavoriteTVShowModel>>> getFavoriteTVShowAsPaged();
}
