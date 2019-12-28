package com.jetpack.movie.model;

import androidx.lifecycle.ViewModel;
import com.jetpack.movie.data.DataDummy;
import java.util.List;

public class TVShowViewModel extends ViewModel {
    public List<TVShowModel> getTVShow() {
        return DataDummy.generateDummyTVShow();
    }
}
