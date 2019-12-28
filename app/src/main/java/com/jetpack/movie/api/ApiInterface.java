package com.jetpack.movie.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("3/movie/popular?api_key=d007adce10e29ffdfd6c4c9807e8c500&language=en-US")
    Call<ResponseBody> getListMovie(@Query("page") String page);

    @GET("3/movie/{id}?api_key=d007adce10e29ffdfd6c4c9807e8c500&language=en-US")
    Call<ResponseBody> getDetailMovie(@Path("id") String id);

    @GET("3/tv/popular?api_key=d007adce10e29ffdfd6c4c9807e8c500&language=en-US")
    Call<ResponseBody> getListTVShow(@Query("page") String page);

    @GET("3/tv/{id}?api_key=d007adce10e29ffdfd6c4c9807e8c500&language=en-US")
    Call<ResponseBody> getDetailTVShow(@Path("id") String id);
}
