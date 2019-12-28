package com.jetpack.movie.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jetpack.movie.data.source.remote.RemoteRepository;
import com.jetpack.movie.data.source.remote.response.MovieResponse;
import com.jetpack.movie.data.source.remote.response.TVShowResponse;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;

import java.util.ArrayList;
import java.util.List;

public class FakeMovieAppRepository implements MovieAppDataSource {
    private volatile static FakeMovieAppRepository INSTANCE = null;

    private final RemoteRepository remoteRepository;

    FakeMovieAppRepository(@NonNull RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static FakeMovieAppRepository getInstance(RemoteRepository remoteData) {
        if (INSTANCE == null) {
            synchronized (FakeMovieAppRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FakeMovieAppRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<MovieModel>> getAllMovies() {
        MutableLiveData<List<MovieModel>> list = new MutableLiveData<>();
        remoteRepository.loadMovies(new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onSuccess(List<MovieResponse> movieResponse) {
                List<MovieModel> movieModels = new ArrayList<>();
                for (int i = 0; i < movieResponse.size(); i++) {
                    MovieResponse response = movieResponse.get(i);
                    MovieModel movie = new MovieModel(response.getMovieId(),
                            response.getPoster(),
                            response.getName(),
                            response.getReleaseDate(),
                            response.getLanguage(),
                            response.getRating(),
                            response.getOverview());

                    movieModels.add(movie);
                }
                list.postValue(movieModels);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
        return list;
    }

    @Override
    public LiveData<MovieModel> getDetailMovie(String id) {
        MutableLiveData<MovieModel> obj = new MutableLiveData<>();
        remoteRepository.loadDetailMovie(id, new RemoteRepository.LoadDetailMovieCallback() {
            @Override
            public void onSuccess(MovieResponse movieResponse) {
                MovieModel model = new MovieModel(movieResponse.getMovieId(),
                        movieResponse.getPoster(),
                        movieResponse.getName(),
                        movieResponse.getReleaseDate(),
                        movieResponse.getLanguage(),
                        movieResponse.getRating(),
                        movieResponse.getOverview());
                obj.postValue(model);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
        return obj;
    }

    @Override
    public LiveData<List<TVShowModel>> getAllTVShows() {
        MutableLiveData<List<TVShowModel>> list = new MutableLiveData<>();
        remoteRepository.loadTVShows(new RemoteRepository.LoadTVShowsCallback() {
            @Override
            public void onSuccess(List<TVShowResponse> tvShowResponse) {
                List<TVShowModel> tvShowModels = new ArrayList<>();
                for (int i = 0; i < tvShowResponse.size(); i++) {
                    TVShowResponse response = tvShowResponse.get(i);
                    TVShowModel tvShow = new TVShowModel(response.getTvId(),
                            response.getPoster(),
                            response.getName(),
                            response.getReleaseDate(),
                            response.getLanguage(),
                            response.getRating(),
                            response.getOverview());

                    tvShowModels.add(tvShow);
                }
                list.postValue(tvShowModels);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
        return list;
    }

    @Override
    public LiveData<TVShowModel> getDetailTVShow(String id) {
        MutableLiveData<TVShowModel> obj = new MutableLiveData<>();
        remoteRepository.loadDetailTVShow(id, new RemoteRepository.LoadDetailTVShowCallback() {
            @Override
            public void onSuccess(TVShowResponse tvShowResponse) {
                TVShowModel model = new TVShowModel(tvShowResponse.getTvId(),
                        tvShowResponse.getPoster(),
                        tvShowResponse.getName(),
                        tvShowResponse.getReleaseDate(),
                        tvShowResponse.getLanguage(),
                        tvShowResponse.getRating(),
                        tvShowResponse.getOverview());
                obj.postValue(model);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
        return obj;
    }

}
