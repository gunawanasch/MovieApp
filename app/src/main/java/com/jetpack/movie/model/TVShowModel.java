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

    public String getPoster() {
        return poster;
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

    public String getLanguage() {
        return language;
    }

    public double getRating() {
        return rating;
    }

    public String getOverview() {
        return overview;
    }

}
