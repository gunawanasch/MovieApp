package com.jetpack.movie.model;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.jetpack.movie.data.source.MovieAppRepository;
import com.jetpack.movie.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoriteMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieAppRepository movieAppRepository = mock(MovieAppRepository.class);
    private FavoriteMovieViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new FavoriteMovieViewModel(movieAppRepository);
    }

    @Test
    public void getFavoriteMovie() {
        MutableLiveData<Resource<PagedList<FavoriteMovieModel>>> dummy = new MutableLiveData<>();
        PagedList<FavoriteMovieModel> pagedList = mock(PagedList.class);
        dummy.setValue(Resource.success(pagedList));
        when(movieAppRepository.getFavoriteMovieAsPaged()).thenReturn(dummy);
        Observer<Resource<PagedList<FavoriteMovieModel>>> observer = mock(Observer.class);
        viewModel.getFavoriteMovieAsPaged().observeForever(observer);
        verify(observer).onChanged(Resource.success(pagedList));
    }

}