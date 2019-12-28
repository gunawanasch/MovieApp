package com.jetpack.movie.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.di.Injection;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;

    private final MovieAppRepository movieAppRepository;

    private ViewModelFactory(MovieAppRepository academyRepository) {
        movieAppRepository = academyRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieViewModel(movieAppRepository);
        } else if (modelClass.isAssignableFrom(TVShowViewModel.class)) {
            //noinspection unchecked
            return (T) new TVShowViewModel(movieAppRepository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            //noinspection unchecked
            return (T) new DetailViewModel(movieAppRepository);
        } else if (modelClass.isAssignableFrom(FavoriteMovieViewModel.class)) {
            //noinspection unchecked
            return (T) new FavoriteMovieViewModel(movieAppRepository);
        } else if (modelClass.isAssignableFrom(FavoriteTVShowViewModel.class)) {
            //noinspection unchecked
            return (T) new FavoriteTVShowViewModel(movieAppRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

}
