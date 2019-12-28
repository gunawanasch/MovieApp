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

public class TVShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TVShowViewModel viewModel;
    private MovieAppRepository movieAppRepository = mock(MovieAppRepository.class);

    @Before
    public void setUp() {
        viewModel = new TVShowViewModel(movieAppRepository);
    }

    @Test
    public void getTVShows() {
        Resource<List<TVShowModel>> resource = Resource.success(FakeDataDummy.generateDummyTVShow());
        MutableLiveData<Resource<List<TVShowModel>>> dummy = new MutableLiveData<>();
        dummy.setValue(resource);
        when(movieAppRepository.getAllTVShows()).thenReturn(dummy);
        Observer<Resource<List<TVShowModel>>> observer = mock(Observer.class);
        viewModel.getTVShow().observeForever(observer);
        verify(observer).onChanged(resource);
    }

}