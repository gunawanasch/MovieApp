package com.jetpack.movie.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "detail_tv")
public class DetailTVShowModel {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tv_id")
    private String tvId;

    @ColumnInfo(name = "poster")
    private String poster;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "release_date")
    private String releaseDate;

    @ColumnInfo(name = "language")
    private String language;

    @ColumnInfo(name = "rating")
    private double rating;

    @ColumnInfo(name = "overview")
    private String overview;

    public DetailTVShowModel(String tvId, String poster, String name, String releaseDate, String language, double rating, String overview) {
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
