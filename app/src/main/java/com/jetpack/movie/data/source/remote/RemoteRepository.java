package com.jetpack.movie.data.source.remote;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jetpack.movie.data.source.remote.response.ApiResponse;
import com.jetpack.movie.data.source.remote.response.DetailMovieResponse;
import com.jetpack.movie.data.source.remote.response.DetailTVShowResponse;
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

    public LiveData<ApiResponse<List<MovieResponse>>> loadMovies() {
        EspressoIdlingResource.increment();  //for idle resource test
        ArrayList<MovieResponse> list = new ArrayList<>();
        MutableLiveData<ApiResponse<List<MovieResponse>>> resultMovie = new MutableLiveData<>();
        ApiInterface api = new ApiClient().getClient().create(ApiInterface.class);
        api.getListMovie(String.valueOf(1)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                EspressoIdlingResource.decrement();  //for idle resource test
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
                        resultMovie.setValue(ApiResponse.success(list));
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
                EspressoIdlingResource.decrement();  //for idle resource test
            }
        });

        return resultMovie;
    }

    public LiveData<ApiResponse<DetailMovieResponse>> loadDetailMovie(String id) {
        EspressoIdlingResource.increment();  //for idle resource test
        MutableLiveData<ApiResponse<DetailMovieResponse>> resultDetailMovie = new MutableLiveData<>();
        ApiInterface api = new ApiClient().getClient().create(ApiInterface.class);
        api.getDetailMovie(id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                EspressoIdlingResource.decrement();  //for idle resource test
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
                        resultDetailMovie.setValue(ApiResponse.success(new DetailMovieResponse(movieId, poster, name, releaseDate, language, rating, overview)));
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
                EspressoIdlingResource.decrement();  //for idle resource test
            }
        });

        return resultDetailMovie;
    }

    public LiveData<ApiResponse<List<TVShowResponse>>> loadTVShows() {
        EspressoIdlingResource.increment();  //for idle resource test
        ArrayList<TVShowResponse> list = new ArrayList<>();
        MutableLiveData<ApiResponse<List<TVShowResponse>>> resultTVShow = new MutableLiveData<>();
        ApiInterface api = new ApiClient().getClient().create(ApiInterface.class);
        api.getListTVShow(String.valueOf(1)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                EspressoIdlingResource.decrement();  //for idle resource test
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
                        resultTVShow.setValue(ApiResponse.success(list));
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
                EspressoIdlingResource.decrement();  //for idle resource test
            }
        });

        return resultTVShow;
    }

    public LiveData<ApiResponse<DetailTVShowResponse>> loadDetailTVShow(String id) {
        EspressoIdlingResource.increment();  //for idle resource test
        MutableLiveData<ApiResponse<DetailTVShowResponse>> resultDetailTVShow = new MutableLiveData<>();
        ApiInterface api = new ApiClient().getClient().create(ApiInterface.class);
        api.getDetailTVShow(id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                EspressoIdlingResource.decrement();  //for idle resource test
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
                        resultDetailTVShow.setValue(ApiResponse.success(new DetailTVShowResponse(tvId, poster, name, releaseDate, language, rating, overview)));
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
                EspressoIdlingResource.decrement();  //for idle resource test
            }
        });

        return resultDetailTVShow;
    }

}
