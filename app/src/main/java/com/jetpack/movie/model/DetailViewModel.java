package com.jetpack.movie.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.vo.Resource;

public class DetailViewModel extends ViewModel {
    private MovieAppRepository movieAppRepository;

    public DetailViewModel(MovieAppRepository movieAppRepository) {
        this.movieAppRepository = movieAppRepository;
    }

    public LiveData<Resource<DetailMovieModel>> getDetailMovie(String id) {
        return movieAppRepository.getDetailMovie(id);
    }

    public LiveData<Resource<DetailTVShowModel>> getDetailTVShow(String id) {
        return movieAppRepository.getDetailTVShow(id);
    }

    public LiveData<FavoriteMovieModel> getFavoriteMovieById(String id) {
        return movieAppRepository.getFavoriteMovieById(id);
    }

    public LiveData<FavoriteTVShowModel> getFavoriteTVShowById(String id) {
        return movieAppRepository.getFavoriteTVShowById(id);
    }

    public void setFavoriteMovie(MovieModel movie) {
        movieAppRepository.insertFavoriteMovie(new FavoriteMovieModel(movie.getMovieId(), movie.getPoster(), movie.getName(), movie.getReleaseDate(), movie.getLanguage(), movie.getRating(), movie.getOverview()));
    }

    public void setFavoriteTvShow(TVShowModel tvShow) {
        movieAppRepository.insertFavoriteTVShow(new FavoriteTVShowModel(tvShow.getTvId(), tvShow.getPoster(), tvShow.getName(), tvShow.getReleaseDate(), tvShow.getLanguage(), tvShow.getRating(), tvShow.getOverview()));
    }

}
