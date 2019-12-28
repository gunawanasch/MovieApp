package com.jetpack.movie.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TVShowViewModelTest {
    private TVShowViewModel vm;

    @Before
    public void setUp() {
        vm = new TVShowViewModel();
    }

    @Test
    public void getTVShows() {
        List<TVShowModel> tvs = vm.getTVShow();
        assertNotNull(tvs);
        assertEquals(10, tvs.size());
    }

}