package com.jetpack.movie.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailViewModelTest {
    private DetailViewModel viewModel;
    private MovieModel dummyMovie;
    private TVShowModel dummyTV;

    @Before
    public void setupData() {
        viewModel = new DetailViewModel();
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
        viewModel.setMovieId(dummyMovie.getMovieId());
        MovieModel sampleMovie = viewModel.getMovie();
        assertNotNull(sampleMovie);
        assertEquals(dummyMovie.getMovieId(), sampleMovie.getMovieId());
        assertEquals(dummyMovie.getName(), sampleMovie.getName());
        assertEquals(String.valueOf(dummyMovie.getRating()), String.valueOf(sampleMovie.getRating()));
        assertEquals(dummyMovie.getReleaseDate(), sampleMovie.getReleaseDate());
        assertEquals(dummyMovie.getOverview(), sampleMovie.getOverview());
        assertEquals(dummyMovie.getPoster(), sampleMovie.getPoster());
    }

    @Test
    public void getDetailTVShow() {
        viewModel.setTvId(dummyTV.getTvId());
        TVShowModel sampleTV = viewModel.geTVShow();
        assertNotNull(sampleTV);
        assertEquals(dummyTV.getTvId(), sampleTV.getTvId());
        assertEquals(dummyTV.getName(), sampleTV.getName());
        assertEquals(String.valueOf(dummyTV.getRating()), String.valueOf(sampleTV.getRating()));
        assertEquals(dummyTV.getReleaseDate(), sampleTV.getReleaseDate());
        assertEquals(dummyTV.getOverview(), sampleTV.getOverview());
        assertEquals(dummyTV.getPoster(), sampleTV.getPoster());
    }

}