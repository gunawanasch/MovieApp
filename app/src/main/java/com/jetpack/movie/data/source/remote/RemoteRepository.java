package com.jetpack.movie.data.source.remote;

import com.jetpack.movie.data.source.remote.response.MovieResponse;
import com.jetpack.movie.data.source.remote.response.TVShowResponse;
import com.jetpack.movie.api.ApiClient;
import com.jetpack.movie.api.ApiInterface;
import com.jetpack.movie.utils.EspressoIdlingResource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;

    private RemoteRepository() {}

    public static RemoteRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository();
        }
        return INSTANCE;
    }

    public void loadMovies(LoadMoviesCallback loadMoviesCallback) {
        EspressoIdlingResource.increment();
        ArrayList<MovieResponse> list = new ArrayList<>();
        ApiInterface api = new ApiClient().getClient().create(ApiInterface.class);
        api.getListMovie(String.valueOf(1)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                EspressoIdlingResource.decrement();
                try {
                    String strResponse = response.body().string();
                    if(response.isSuccessful()) {
                        JSONObject responseObject = new JSONObject(strResponse);
                        JSONArray listArray = responseObject.getJSONArray("results");
                        for (int i = 0; i < listArray.length(); i++) {
                            JSONObject obj = listArray.getJSONObject(i);

                            String movieId = obj.getString("id");
                            String poster = obj.getString("poster_path");
                            String name = obj.getString("title");
                            String releaseDate = obj.getString("release_date");
                            String language = obj.getString("original_language");
                            double rating = Double.parseDouble(obj.getString("vote_average"));
                            String overview = obj.getString("overview");

                            MovieResponse movieResponse = new MovieResponse(movieId, poster, name, releaseDate, language, rating, overview);
                            list.add(movieResponse);
                        }
                        loadMoviesCallback.onSuccess(list);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                EspressoIdlingResource.decrement();
                loadMoviesCallback.onError(t.getMessage());
            }
        });
    }

    public void loadDetailMovie(String id, LoadDetailMovieCallback loadDetailMovieCallback) {
        EspressoIdlingResource.increment();
        ApiInterface api = new ApiClient().getClient().create(ApiInterface.class);
        api.getDetailMovie(id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                EspressoIdlingResource.decrement();
                try {
                    String strResponse = response.body().string();
                    if(response.isSuccessful()) {
                        JSONObject obj = new JSONObject(strResponse);
                        String movieId = obj.getString("id");
                        String poster = obj.getString("poster_path");
                        String name = obj.getString("title");
                        String releaseDate = obj.getString("release_date");
                        String language = obj.getString("original_language");
                        double rating = Double.parseDouble(obj.getString("vote_average"));
                        String overview = obj.getString("overview");
                        loadDetailMovieCallback.onSuccess(new MovieResponse(movieId, poster, name, releaseDate, language, rating, overview));
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                EspressoIdlingResource.decrement();
                loadDetailMovieCallback.onError(t.getMessage());
            }
        });
    }

    public void loadTVShows(LoadTVShowsCallback loadTVShowsCallback) {
        EspressoIdlingResource.increment();
        ArrayList<TVShowResponse> list = new ArrayList<>();
        ApiInterface api = new ApiClient().getClient().create(ApiInterface.class);
        api.getListTVShow(String.valueOf(1)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                EspressoIdlingResource.decrement();
                try {
                    String strResponse = response.body().string();
                    if(response.isSuccessful()) {
                        JSONObject responseObject = new JSONObject(strResponse);
                        JSONArray listArray = responseObject.getJSONArray("results");
                        for (int i = 0; i < listArray.length(); i++) {
                            JSONObject obj = listArray.getJSONObject(i);

                            String tvId = obj.getString("id");
                            String poster = obj.getString("poster_path");
                            String name = obj.getString("name");
                            String releaseDate = obj.getString("first_air_date");
                            String language = obj.getString("original_language");
                            double rating = Double.parseDouble(obj.getString("vote_average"));
                            String overview = obj.getString("overview");

                            TVShowResponse tvShowResponse = new TVShowResponse(tvId, poster, name, releaseDate, language, rating, overview);
                            list.add(tvShowResponse);
                        }
                        loadTVShowsCallback.onSuccess(list);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                EspressoIdlingResource.decrement();
                loadTVShowsCallback.onError(t.getMessage());
            }
        });
    }

    public void loadDetailTVShow(String id, LoadDetailTVShowCallback loadDetailTVShowCallback) {
        EspressoIdlingResource.increment();
        ApiInterface api = new ApiClient().getClient().create(ApiInterface.class);
        api.geDetailTVShow(id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                EspressoIdlingResource.decrement();
                try {
                    String strResponse = response.body().string();
                    if(response.isSuccessful()) {
                        JSONObject obj = new JSONObject(strResponse);
                        String tvId = obj.getString("id");
                        String poster = obj.getString("poster_path");
                        String name = obj.getString("name");
                        String releaseDate = obj.getString("first_air_date");
                        String language = obj.getString("original_language");
                        double rating = Double.parseDouble(obj.getString("vote_average"));
                        String overview = obj.getString("overview");
                        loadDetailTVShowCallback.onSuccess(new TVShowResponse(tvId, poster, name, releaseDate, language, rating, overview));
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                EspressoIdlingResource.decrement();
                loadDetailTVShowCallback.onError(t.getMessage());
            }
        });
    }

    public interface LoadMoviesCallback {
        void onSuccess(List<MovieResponse> movieResponse);
        void onError(String errorMessage);
    }

    public interface LoadDetailMovieCallback {
        void onSuccess(MovieResponse movieResponse);
        void onError(String errorMessage);
    }

    public interface LoadTVShowsCallback {
        void onSuccess(List<TVShowResponse> tvShowResponse);
        void onError(String errorMessage);
    }

    public interface LoadDetailTVShowCallback {
        void onSuccess(TVShowResponse tvShowResponse);
        void onError(String errorMessage);
    }

}
