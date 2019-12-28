package com.jetpack.movie.model;

public class TVShowModel {
    private String tvId;
    private String poster;
    private String name;
    private String releaseDate;
    private String language;
    private double rating;
    private String overview;


    public TVShowModel(String tvId, String poster, String name, String releaseDate, String language, double rating, String overview) {
        this.tvId = tvId;
        this.poster = poster;
        this.name = name;
        this.releaseDate = releaseDate;
        this.language = language;
        this.rating = rating;
        this.overview = overview;
    }

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
