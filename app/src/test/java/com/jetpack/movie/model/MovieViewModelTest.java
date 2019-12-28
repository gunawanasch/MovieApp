package com.jetpack.movie.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {
    private MovieViewModel vm;

    @Before
    public void setUp() {
        vm = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        List<MovieModel> movies = vm.getMovie();
        assertNotNull(movies);
        assertEquals(10, movies.size());
    }

}