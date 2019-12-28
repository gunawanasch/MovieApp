package com.jetpack.movie.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.jetpack.movie.data.source.local.LocalRepository;
import com.jetpack.movie.data.source.remote.RemoteRepository;
import com.jetpack.movie.data.source.remote.response.ApiResponse;
import com.jetpack.movie.data.source.remote.response.DetailMovieResponse;
import com.jetpack.movie.data.source.remote.response.DetailTVShowResponse;
import com.jetpack.movie.data.source.remote.response.MovieResponse;
import com.jetpack.movie.data.source.remote.response.TVShowResponse;
import com.jetpack.movie.model.DetailMovieModel;
import com.jetpack.movie.model.DetailTVShowModel;
import com.jetpack.movie.model.FavoriteMovieModel;
import com.jetpack.movie.model.FavoriteTVShowModel;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;
import com.jetpack.movie.utils.AppExecutors;
import com.jetpack.movie.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class MovieAppRepository implements MovieAppDataSource {
    private volatile static MovieAppRepository INSTANCE = null;
    private final RemoteRepository remoteRepository;
    private final LocalRepository localRepository;
    private final AppExecutors appExecutors;

    MovieAppRepository(@NonNull RemoteRepository remoteRepository, @NonNull LocalRepository localRepository, AppExecutors appExecutors) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
        this.appExecutors = appExecutors;
    }

    public static MovieAppRepository getInstance(RemoteRepository remoteData, LocalRepository localRepository, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (MovieAppRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieAppRepository(remoteData, localRepository, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<List<MovieModel>>> getAllMovies() {
        return new NetworkBoundResource<List<MovieModel>, List<MovieResponse>>(appExecutors) {
            @Override
            public LiveData<List<MovieModel>> loadFromDB() {
                return localRepository.getAllMovies();
            }

            @Override
            public Boolean shouldFetch(List<MovieModel> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            public LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteRepository.loadMovies();
            }

            @Override
            public void saveCallResult(List<MovieResponse> responses) {
                List<MovieModel> model = new ArrayList<>();
                for (MovieResponse movieResponse : responses) {
                    model.add(new MovieModel(movieResponse.getMovieId(), movieResponse.getPoster(), movieResponse.getName(), movieResponse.getReleaseDate(), movieResponse.getLanguage(), movieResponse.getRating(), movieResponse.getOverview()));
                }
                localRepository.insertAllMovies(model);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<DetailMovieModel>> getDetailMovie(String id) {
        return new NetworkBoundResource<DetailMovieModel, DetailMovieResponse>(appExecutors) {
            @Override
            public LiveData<DetailMovieModel> loadFromDB() {
                return localRepository.getDetailMovie(id);
            }

            @Override
            public Boolean shouldFetch(DetailMovieModel data) {
                return (data == null);
            }

            @Override
            public LiveData<ApiResponse<DetailMovieResponse>> createCall() {
                return remoteRepository.loadDetailMovie(id);
            }

            @Override
            public void saveCallResult(DetailMovieResponse response) {
                localRepository.insertDetailMovie(new DetailMovieModel(response.getMovieId(), response.getPoster(), response.getName(), response.getReleaseDate(), response.getLanguage(), response.getRating(), response.getOverview()));
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TVShowModel>>> getAllTVShows() {
        return new NetworkBoundResource<List<TVShowModel>, List<TVShowResponse>>(appExecutors) {
            @Override
            public LiveData<List<TVShowModel>> loadFromDB() {
                return localRepository.getAllTVShows();
            }

            @Override
            public Boolean shouldFetch(List<TVShowModel> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            public LiveData<ApiResponse<List<TVShowResponse>>> createCall() {
                return remoteRepository.loadTVShows();
            }

            @Override
            public void saveCallResult(List<TVShowResponse> responses) {
                List<TVShowModel> model = new ArrayList<>();
                for (TVShowResponse tvShowResponse : responses) {
                    model.add(new TVShowModel(tvShowResponse.getTvId(), tvShowResponse.getPoster(), tvShowResponse.getName(), tvShowResponse.getReleaseDate(), tvShowResponse.getLanguage(), tvShowResponse.getRating(), tvShowResponse.getOverview()));
                }
                localRepository.insertAllTVShows(model);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<DetailTVShowModel>> getDetailTVShow(String id) {
        return new NetworkBoundResource<DetailTVShowModel, DetailTVShowResponse>(appExecutors) {
            @Override
            public LiveData<DetailTVShowModel> loadFromDB() {
                return localRepository.getDetailTVShow(id);
            }

            @Override
            public Boolean shouldFetch(DetailTVShowModel data) {
                return (data == null);
            }

            @Override
            public LiveData<ApiResponse<DetailTVShowResponse>> createCall() {
                return remoteRepository.loadDetailTVShow(id);
            }

            @Override
            public void saveCallResult(DetailTVShowResponse response) {
                localRepository.insertDetailTVShow(new DetailTVShowModel(response.getTvId(), response.getPoster(), response.getName(), response.getReleaseDate(), response.getLanguage(), response.getRating(), response.getOverview()));
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<FavoriteMovieModel>>> getFavoriteMovieAsPaged() {
        return new NetworkBoundResource<PagedList<FavoriteMovieModel>, List<MovieResponse>>(appExecutors) {
            @Override
            protected LiveData<PagedList<FavoriteMovieModel>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getFavoriteMovieAsPaged(), /* page size */ 10).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<FavoriteMovieModel> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<PagedList<FavoriteTVShowModel>>> getFavoriteTVShowAsPaged() {
        return new NetworkBoundResource<PagedList<FavoriteTVShowModel>, List<TVShowResponse>>(appExecutors) {
            @Override
            protected LiveData<PagedList<FavoriteTVShowModel>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getFavoriteTVShowAsPaged(), /* page size */ 10).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<FavoriteTVShowModel> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<TVShowResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<TVShowResponse> data) {

            }
        }.asLiveData();
    }

    public LiveData<FavoriteMovieModel> getFavoriteMovieById(String id) {
        return localRepository.getFavoriteMovieById(id);
    }

    public LiveData<FavoriteTVShowModel> getFavoriteTVShowById(String id) {
        return localRepository.getFavoriteTVShowById(id);
    }

    public void insertFavoriteMovie(FavoriteMovieModel movie) {
        Runnable runnable = () -> localRepository.insertFavoriteMovie(movie);
        appExecutors.diskIO().execute(runnable);
    }

    public void insertFavoriteTVShow(FavoriteTVShowModel tvShow) {
        Runnable runnable = () -> localRepository.insertFavoriteTVShow(tvShow);
        appExecutors.diskIO().execute(runnable);
    }

    public void deleteFavoriteMovie(String id) {
        Runnable runnable = () -> localRepository.deleteFavoriteMovie(id);
        appExecutors.diskIO().execute(runnable);
    }

    public void deleteFavoriteTVShow(String id) {
        Runnable runnable = () -> localRepository.deleteFavoriteTVShow(id);
        appExecutors.diskIO().execute(runnable);
    }

}
