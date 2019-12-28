package com.jetpack.movie.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.jetpack.movie.data.source.remote.RemoteRepository;
import com.jetpack.movie.data.source.remote.response.MovieResponse;
import com.jetpack.movie.data.source.remote.response.TVShowResponse;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;
import com.jetpack.movie.utils.FakeDataDummy;
import com.jetpack.movie.utils.LiveDataTestUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MovieAppRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteRepository remote = Mockito.mock(RemoteRepository.class);
    private FakeMovieAppRepository fakeMovieAppRepository = new FakeMovieAppRepository(remote);
    private ArrayList<MovieResponse> listMovie = FakeDataDummy.generateRemoteDummyMovie();
    private ArrayList<TVShowResponse> listTVShow = FakeDataDummy.generateRemoteDummyTVShow();
    private MovieResponse movie = FakeDataDummy.generateRemoteDummyMovie().get(0);
    private TVShowResponse tvShow = FakeDataDummy.generateRemoteDummyTVShow().get(0);


    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void getAllMovies() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMoviesCallback) invocation.getArguments()[0]).onSuccess(listMovie);
            return null;
        }).when(remote).loadMovies(any(RemoteRepository.LoadMoviesCallback.class));
        List<MovieModel> result = LiveDataTestUtil.getValue(fakeMovieAppRepository.getAllMovies());
        verify(remote, times(1)).loadMovies(any(RemoteRepository.LoadMoviesCallback.class));
        assertNotNull(result);
        assertEquals(listMovie.size(), result.size());
    }

    @Test
    public void getDetailMovie() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadDetailMovieCallback) invocation.getArguments()[1]).onSuccess(movie);
            return null;
        }).when(remote).loadDetailMovie(eq(movie.getMovieId()), any(RemoteRepository.LoadDetailMovieCallback.class));
        MovieModel result = LiveDataTestUtil.getValue(fakeMovieAppRepository.getDetailMovie(movie.getMovieId()));
        verify(remote, times(1)).loadDetailMovie(eq(movie.getMovieId()), any(RemoteRepository.LoadDetailMovieCallback.class));
        assertNotNull(result);
        assertNotNull(result.getName());
        assertEquals(movie.getName(), result.getName());
    }

    @Test
    public void getAllTVShows() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTVShowsCallback) invocation.getArguments()[0]).onSuccess(listTVShow);
            return null;
        }).when(remote).loadTVShows(any(RemoteRepository.LoadTVShowsCallback.class));
        List<TVShowModel> result = LiveDataTestUtil.getValue(fakeMovieAppRepository.getAllTVShows());
        verify(remote, times(1)).loadTVShows(any(RemoteRepository.LoadTVShowsCallback.class));
        assertNotNull(result);
        assertEquals(listMovie.size(), result.size());
    }

    @Test
    public void getDetailTVShow() {
        doAnswer(invocation -> {
            ((RemoteRepository.LoadDetailTVShowCallback) invocation.getArguments()[1]).onSuccess(tvShow);
            return null;
        }).when(remote).loadDetailTVShow(eq(tvShow.getTvId()), any(RemoteRepository.LoadDetailTVShowCallback.class));
        TVShowModel result = LiveDataTestUtil.getValue(fakeMovieAppRepository.getDetailTVShow(tvShow.getTvId()));
        verify(remote, times(1)).loadDetailTVShow(eq(tvShow.getTvId()), any(RemoteRepository.LoadDetailTVShowCallback.class));
        assertNotNull(result);
        assertNotNull(result.getName());
        assertEquals(tvShow.getName(), result.getName());
    }

}