package com.jetpack.movie.di;

import android.app.Application;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.data.source.local.LocalRepository;
import com.jetpack.movie.data.source.local.room.MovieAppDatabase;
import com.jetpack.movie.data.source.remote.RemoteRepository;
import com.jetpack.movie.utils.AppExecutors;

public class Injection {
    public static MovieAppRepository provideRepository(Application application) {
        MovieAppDatabase database = MovieAppDatabase.getInstance(application);
        RemoteRepository remoteRepository = RemoteRepository.getInstance();
        LocalRepository localRepository = LocalRepository.getInstance(database.movieAppDao());
        AppExecutors appExecutors = new AppExecutors();
        return MovieAppRepository.getInstance(remoteRepository, localRepository, appExecutors);
    }
}
