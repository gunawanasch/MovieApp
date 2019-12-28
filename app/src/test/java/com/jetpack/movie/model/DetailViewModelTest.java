package com.jetpack.movie.model;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jetpack.movie.data.source.MovieAppRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailViewModel viewModel;
    private MovieModel dummyMovie;
    private TVShowModel dummyTV;
    private MovieAppRepository movieAppRepository = mock(MovieAppRepository.class);

    @Before
    public void setupData() {
        viewModel = new DetailViewModel(movieAppRepository);
        dummyMovie = new MovieModel("384018",
                "https://image.tmdb.org/t/p/w500/keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
                "Fast & Furious Presents: Hobbs & Shaw",
                "2019-08-02",
                "en",
                6.5,
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.");
        dummyTV = new TVShowModel("12971",
                "https://image.tmdb.org/t/p/w500/lCvOCn1Hq0ugBL6T8SyMoaCWNOc.jpg",
                "Dragon Ball Z",
                "1989-04-26",
                "ja",
                8.0,
                "Five years have passed since the fight with Piccolo Jr. and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.");
    }

    @Test
    public void getDetailMovie() {
        MutableLiveData<MovieModel> movie = new MutableLiveData<>();
        movie.setValue(dummyMovie);
        when(movieAppRepository.getDetailMovie(dummyMovie.getMovieId())).thenReturn(movie);
        Observer<MovieModel> observer = mock(Observer.class);
        viewModel.getDetailMovie(dummyMovie.getMovieId()).observeForever(observer);
        verify(observer).onChanged(dummyMovie);
    }

    @Test
    public void getDetailTVShow() {
        MutableLiveData<TVShowModel> tvShow = new MutableLiveData<>();
        tvShow.setValue(dummyTV);
        when(movieAppRepository.getDetailTVShow(dummyTV.getTvId())).thenReturn(tvShow);
        Observer<TVShowModel> observer = mock(Observer.class);
        viewModel.getDetailTVShow(dummyTV.getTvId()).observeForever(observer);
        verify(observer).onChanged(dummyTV);
    }

}