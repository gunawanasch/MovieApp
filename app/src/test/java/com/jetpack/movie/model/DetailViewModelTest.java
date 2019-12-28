package com.jetpack.movie.model;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.utils.FakeDataDummy;
import com.jetpack.movie.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DetailViewModel viewModel;
    private DetailMovieModel dummyMovie;
    private DetailTVShowModel dummyTV;
    private MovieAppRepository movieAppRepository = mock(MovieAppRepository.class);

    @Before
    public void setupData() {
        viewModel = new DetailViewModel(movieAppRepository);
        dummyMovie = new DetailMovieModel("384018",
                "keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
                "Fast & Furious Presents: Hobbs & Shaw",
                "2019-08-02",
                "en",
                6.5,
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.");
        dummyTV = new DetailTVShowModel("12971",
                "lCvOCn1Hq0ugBL6T8SyMoaCWNOc.jpg",
                "Dragon Ball Z",
                "1989-04-26",
                "ja",
                8.0,
                "Five years have passed since the fight with Piccolo Jr. and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.");
    }

    @Test
    public void getDetailMovie() {
        Resource<DetailMovieModel> resource = Resource.success(dummyMovie);
        MutableLiveData<Resource<DetailMovieModel>> dummy = new MutableLiveData<>();
        dummy.setValue(resource);
        when(movieAppRepository.getDetailMovie(dummyMovie.getMovieId())).thenReturn(dummy);
        Observer<Resource<DetailMovieModel>> observer = mock(Observer.class);
        viewModel.getDetailMovie(dummyMovie.getMovieId()).observeForever(observer);
        verify(observer).onChanged(resource);
    }

    @Test
    public void getDetailTVShow() {
        Resource<DetailTVShowModel> resource = Resource.success(dummyTV);
        MutableLiveData<Resource<DetailTVShowModel>> dummy = new MutableLiveData<>();
        dummy.setValue(resource);
        when(movieAppRepository.getDetailTVShow(dummyTV.getTvId())).thenReturn(dummy);
        Observer<Resource<DetailTVShowModel>> observer = mock(Observer.class);
        viewModel.getDetailTVShow(dummyTV.getTvId()).observeForever(observer);
        verify(observer).onChanged(resource);
    }

}