package com.jetpack.movie.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieResponse implements Parcelable {
    private String movieId;
    private String poster;
    private String name;
    private String releaseDate;
    private String language;
    private double rating;
    private String overview;

    public MovieResponse(String movieId, String poster, String name, String releaseDate, String language, double rating, String overview) {
        this.movieId = movieId;
        this.poster = poster;
        this.name = name;
        this.releaseDate = releaseDate;
        this.language = language;
        this.rating = rating;
        this.overview = overview;
    }

    public String getMovieId() {
        return movieId;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movieId);
        dest.writeString(this.poster);
        dest.writeString(this.name);
        dest.writeString(this.releaseDate);
        dest.writeString(this.language);
        dest.writeDouble(this.rating);
        dest.writeString(this.overview);
    }

    protected MovieResponse(Parcel in) {
        this.movieId = in.readString();
        this.poster = in.readString();
        this.name = in.readString();
        this.releaseDate = in.readString();
        this.language = in.readString();
        this.rating = in.readDouble();
        this.overview = in.readString();
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel source) {
            return new MovieResponse(source);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };

}
