package com.jetpack.movie.model;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel viewModel;
    private MovieAppRepository movieAppRepository = mock(MovieAppRepository.class);

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(movieAppRepository);
    }

    @Test
    public void getMovies() {
        List<MovieModel> dummyMovie = FakeDataDummy.generateDummyMovie();
        MutableLiveData<List<MovieModel>> listMovie = new MutableLiveData<>();
        listMovie.setValue(dummyMovie);
        when(movieAppRepository.getAllMovies()).thenReturn(listMovie);
        Observer<List<MovieModel>> observer = mock(Observer.class);
        viewModel.getMovie().observeForever(observer);
        verify(observer).onChanged(dummyMovie);
    }

}