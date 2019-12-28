package com.jetpack.movie.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.jetpack.movie.data.source.local.LocalRepository;
import com.jetpack.movie.data.source.remote.RemoteRepository;
import com.jetpack.movie.data.source.remote.response.MovieResponse;
import com.jetpack.movie.data.source.remote.response.TVShowResponse;
import com.jetpack.movie.model.DetailMovieModel;
import com.jetpack.movie.model.DetailTVShowModel;
import com.jetpack.movie.model.FavoriteMovieModel;
import com.jetpack.movie.model.FavoriteTVShowModel;
import com.jetpack.movie.model.FavoriteTVShowViewModel;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;
import com.jetpack.movie.utils.AppExecutors;
import com.jetpack.movie.utils.FakeDataDummy;
import com.jetpack.movie.utils.InstantAppExecutors;
import com.jetpack.movie.utils.LiveDataTestUtil;
import com.jetpack.movie.utils.PagedListUtil;
import com.jetpack.movie.vo.Resource;

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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieAppRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private RemoteRepository remote = mock(RemoteRepository.class);
    private LocalRepository local = Mockito.mock(LocalRepository.class);
    private InstantAppExecutors appExecutors = Mockito.mock(InstantAppExecutors.class);
    private FakeMovieAppRepository fakeMovieAppRepository = new FakeMovieAppRepository(remote, local, appExecutors);
    private ArrayList<MovieResponse> listMovie = FakeDataDummy.generateRemoteDummyMovie();
    private ArrayList<TVShowResponse> listTVShow = FakeDataDummy.generateRemoteDummyTVShow();
    private ArrayList<FavoriteMovieModel> listFavoriteMovie = FakeDataDummy.generateDummyFavoriteMovie();
    private ArrayList<FavoriteTVShowModel> listFavoriteTVShow = FakeDataDummy.generateDummyFavoriteTVShow();
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
        MutableLiveData<List<MovieModel>> dummy = new MutableLiveData<>();
        dummy.setValue(FakeDataDummy.generateDummyMovie());
        when(local.getAllMovies()).thenReturn(dummy);
        Resource<List<MovieModel>> result = LiveDataTestUtil.getValue(fakeMovieAppRepository.getAllMovies());
        verify(local).getAllMovies();
        assertNotNull(result.data);
        assertEquals(listMovie.size(), result.data.size());
    }

    @Test
    public void getDetailMovie() {
        DetailMovieModel model = new DetailMovieModel(movie.getMovieId(), movie.getPoster(), movie.getName(), movie.getReleaseDate(), movie.getLanguage(), movie.getRating(), movie.getOverview());
        MutableLiveData<DetailMovieModel> dummy = new MutableLiveData<>();
        dummy.setValue(model);
        when(local.getDetailMovie(model.getMovieId())).thenReturn(dummy);
        Resource<DetailMovieModel> result = LiveDataTestUtil.getValue(fakeMovieAppRepository.getDetailMovie(model.getMovieId()));
        verify(local).getDetailMovie(model.getMovieId());
        assertNotNull(result.data);
        assertEquals(movie.getName(), result.data.getName());
    }

    @Test
    public void getAllTVShows() {
        MutableLiveData<List<TVShowModel>> dummy = new MutableLiveData<>();
        dummy.setValue(FakeDataDummy.generateDummyTVShow());
        when(local.getAllTVShows()).thenReturn(dummy);
        Resource<List<TVShowModel>> result = LiveDataTestUtil.getValue(fakeMovieAppRepository.getAllTVShows());
        verify(local).getAllTVShows();
        assertNotNull(result.data);
        assertEquals(listTVShow.size(), result.data.size());
    }

    @Test
    public void getDetailTVShow() {
        DetailTVShowModel model = new DetailTVShowModel(tvShow.getTvId(), tvShow.getPoster(), tvShow.getName(), tvShow.getReleaseDate(), tvShow.getLanguage(), tvShow.getRating(), tvShow.getOverview());
        MutableLiveData<DetailTVShowModel> dummy = new MutableLiveData<>();
        dummy.setValue(model);
        when(local.getDetailTVShow(model.getTvId())).thenReturn(dummy);
        Resource<DetailTVShowModel> result = LiveDataTestUtil.getValue(fakeMovieAppRepository.getDetailTVShow(model.getTvId()));
        verify(local).getDetailTVShow(model.getTvId());
        assertNotNull(result.data);
        assertEquals(tvShow.getName(), result.data.getName());
    }

    @Test
    public void getFavoriteMovie() {
        DataSource.Factory<Integer, FavoriteMovieModel> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getFavoriteMovieAsPaged()).thenReturn(dataSourceFactory);
        fakeMovieAppRepository.getFavoriteMovieAsPaged();
        Resource<PagedList<FavoriteMovieModel>> result = Resource.success(PagedListUtil.mockPagedList(listFavoriteMovie));
        verify(local).getFavoriteMovieAsPaged();
        assertNotNull(result.data);
        assertEquals(listMovie.size(), result.data.size());
    }

    @Test
    public void getFavoriteTVShow() {
        DataSource.Factory<Integer, FavoriteTVShowModel> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getFavoriteTVShowAsPaged()).thenReturn(dataSourceFactory);
        fakeMovieAppRepository.getFavoriteTVShowAsPaged();
        Resource<PagedList<FavoriteTVShowModel>> result = Resource.success(PagedListUtil.mockPagedList(listFavoriteTVShow));
        verify(local).getFavoriteTVShowAsPaged();
        assertNotNull(result.data);
        assertEquals(listFavoriteTVShow.size(), result.data.size());
    }

}