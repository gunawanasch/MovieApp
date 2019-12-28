package com.jetpack.movie.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jetpack.movie.model.DetailMovieModel;
import com.jetpack.movie.model.DetailTVShowModel;
import com.jetpack.movie.model.FavoriteMovieModel;
import com.jetpack.movie.model.FavoriteTVShowModel;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;

@Database(entities = {MovieModel.class, DetailMovieModel.class, TVShowModel.class, DetailTVShowModel.class,
        FavoriteMovieModel.class, FavoriteTVShowModel.class},
        version = 1,
        exportSchema = false)
public abstract class MovieAppDatabase extends RoomDatabase {
    private static MovieAppDatabase INSTANCE;
    public abstract MovieAppDao movieAppDao();
    private static final Object sLock = new Object();

    public static MovieAppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        MovieAppDatabase.class, "MovieApp.db")
                        .build();
            }
            return INSTANCE;
        }
    }

}
