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
        Resource<List<MovieModel>> resource = Resource.success(FakeDataDummy.generateDummyMovie());
        MutableLiveData<Resource<List<MovieModel>>> dummy = new MutableLiveData<>();
        dummy.setValue(resource);
        when(movieAppRepository.getAllMovies()).thenReturn(dummy);
        Observer<Resource<List<MovieModel>>> observer = mock(Observer.class);
        viewModel.getMovie().observeForever(observer);
        verify(observer).onChanged(resource);
    }

}