package com.jetpack.movie.model;

import androidx.lifecycle.ViewModel;
import com.jetpack.movie.data.DataDummy;
import java.util.List;

public class MovieViewModel extends ViewModel {
    public List<MovieModel> getMovie() {
        return DataDummy.generateDummyMovie();
    }
}