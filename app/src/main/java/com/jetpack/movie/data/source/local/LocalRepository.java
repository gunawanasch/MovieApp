package com.jetpack.movie.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.jetpack.movie.data.source.local.room.MovieAppDao;
import com.jetpack.movie.model.DetailMovieModel;
import com.jetpack.movie.model.DetailTVShowModel;
import com.jetpack.movie.model.FavoriteMovieModel;
import com.jetpack.movie.model.FavoriteTVShowModel;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;

import java.util.List;

public class LocalRepository {
    private final MovieAppDao movieAppDao;

    private LocalRepository(MovieAppDao movieAppDao) {
        this.movieAppDao = movieAppDao;
    }

    private static LocalRepository INSTANCE;

    public static LocalRepository getInstance(MovieAppDao movieAppDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalRepository(movieAppDao);
        }
        return INSTANCE;
    }

    public LiveData<List<MovieModel>> getAllMovies() {
        return movieAppDao.getAllMovies();
    }

    public void insertAllMovies(List<MovieModel> movies) {
        movieAppDao.insertAllMovies(movies);
    }

    public LiveData<DetailMovieModel> getDetailMovie(String id) {
        return movieAppDao.getDetailMovie(id);
    }

    public void insertDetailMovie(DetailMovieModel detailMovie) {
        movieAppDao.insertDetailMovie(detailMovie);
    }

    public LiveData<List<TVShowModel>> getAllTVShows() {
        return movieAppDao.getAllTVShows();
    }

    public void insertAllTVShows(List<TVShowModel> tvShows) {
        movieAppDao.insertAllTVShows(tvShows);
    }

    public LiveData<DetailTVShowModel> getDetailTVShow(String id) {
        return movieAppDao.getDetailTVShow(id);
    }

    public void insertDetailTVShow(DetailTVShowModel detailTVShow) {
        movieAppDao.insertDetailTVShow(detailTVShow);
    }

    public DataSource.Factory<Integer, FavoriteMovieModel> getFavoriteMovieAsPaged() {
        return movieAppDao.getFavoriteMovieAsPaged();
    }

    public DataSource.Factory<Integer, FavoriteTVShowModel> getFavoriteTVShowAsPaged() {
        return movieAppDao.getFavoriteTVShowAsPaged();
    }

    public LiveData<FavoriteMovieModel> getFavoriteMovieById(String id) {
        return movieAppDao.getFavoriteMovieById(id);
    }

    public LiveData<FavoriteTVShowModel> getFavoriteTVShowById(String id) {
        return movieAppDao.getFavoriteTVShowById(id);
    }

    public void insertFavoriteMovie(FavoriteMovieModel movie) {
        movieAppDao.insertFavoriteMovie(movie);
    }

    public void insertFavoriteTVShow(FavoriteTVShowModel tvShow) {
        movieAppDao.insertFavoriteTVShow(tvShow);
    }

    public void deleteFavoriteMovie(String id) {
        movieAppDao.deleteFavoriteMovie(id);
    }

    public void deleteFavoriteTVShow(String id) {
        movieAppDao.deleteFavoriteTVShow(id);
    }

}
