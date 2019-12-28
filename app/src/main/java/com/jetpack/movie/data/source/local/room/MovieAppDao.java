package com.jetpack.movie.data.source.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.jetpack.movie.model.DetailMovieModel;
import com.jetpack.movie.model.DetailTVShowModel;
import com.jetpack.movie.model.FavoriteMovieModel;
import com.jetpack.movie.model.FavoriteTVShowModel;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;

import java.util.List;

@Dao
public interface MovieAppDao {
    @WorkerThread
    @Query("SELECT * FROM movie")
    LiveData<List<MovieModel>> getAllMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAllMovies(List<MovieModel> movies);

    @WorkerThread
    @Query("SELECT * FROM detail_movie WHERE movie_id = :id")
    LiveData<DetailMovieModel> getDetailMovie(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertDetailMovie(DetailMovieModel detailMovie);

    @WorkerThread
    @Query("SELECT * FROM tv")
    LiveData<List<TVShowModel>> getAllTVShows();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAllTVShows(List<TVShowModel> tvShows);

    @WorkerThread
    @Query("SELECT * FROM detail_tv WHERE tv_id = :id")
    LiveData<DetailTVShowModel> getDetailTVShow(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertDetailTVShow(DetailTVShowModel detailTVShows);

    @Query("SELECT * FROM favorite_movie")
    DataSource.Factory<Integer, FavoriteMovieModel> getFavoriteMovieAsPaged();

    @Query("SELECT * FROM favorite_tv")
    DataSource.Factory<Integer, FavoriteTVShowModel> getFavoriteTVShowAsPaged();

    @WorkerThread
    @Query("SELECT * FROM favorite_movie WHERE movie_id = :id")
    LiveData<FavoriteMovieModel> getFavoriteMovieById(String id);

    @WorkerThread
    @Query("SELECT * FROM favorite_tv WHERE tv_id = :id")
    LiveData<FavoriteTVShowModel> getFavoriteTVShowById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertFavoriteMovie(FavoriteMovieModel favoriteMovie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertFavoriteTVShow(FavoriteTVShowModel favoriteTVShow);

    @Query("DELETE FROM favorite_movie WHERE movie_id = :id")
    int deleteFavoriteMovie(String id);

    @Query("DELETE FROM favorite_tv WHERE tv_id = :id")
    int deleteFavoriteTVShow(String id);

}
