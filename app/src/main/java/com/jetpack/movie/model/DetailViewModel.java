package com.jetpack.movie.model;

import androidx.lifecycle.ViewModel;
import com.jetpack.movie.data.DataDummy;

public class DetailViewModel extends ViewModel {
    private MovieModel movie;
    private String movieId;
    private TVShowModel tv;
    private String tvId;

    public MovieModel getMovie() {
        for (int i = 0; i < DataDummy.generateDummyMovie().size(); i++) {
            MovieModel movieModel = DataDummy.generateDummyMovie().get(i);
            if (movieModel.getMovieId().equals(movieId)) {
                movie = movieModel;
            }
        }
        return movie;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public TVShowModel geTVShow() {
        for (int i = 0; i < DataDummy.generateDummyTVShow().size(); i++) {
            TVShowModel tvShowModel = DataDummy.generateDummyTVShow().get(i);
            if (tvShowModel.getTvId().equals(tvId)) {
                tv = tvShowModel;
            }
        }
        return tv;
    }

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId;
    }
}
