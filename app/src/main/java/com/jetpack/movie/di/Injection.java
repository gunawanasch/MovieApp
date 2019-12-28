package com.jetpack.movie.di;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.data.source.remote.RemoteRepository;

public class Injection {
    public static MovieAppRepository provideRepository() {
        RemoteRepository remoteRepository = RemoteRepository.getInstance();
        return MovieAppRepository.getInstance(remoteRepository);
    }
}
