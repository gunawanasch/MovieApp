package com.jetpack.movie.data.source.remote.response;

import android.os.Parcel;
import android.os.Parcelable;

public class DetailTVShowResponse implements Parcelable {
    private String tvId;
    private String poster;
    private String name;
    private String releaseDate;
    private String language;
    private double rating;
    private String overview;

    public DetailTVShowResponse(String tvId, String poster, String name, String releaseDate, String language, double rating, String overview) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tvId);
        dest.writeString(this.poster);
        dest.writeString(this.name);
        dest.writeString(this.releaseDate);
        dest.writeString(this.language);
        dest.writeDouble(this.rating);
        dest.writeString(this.overview);
    }

    protected DetailTVShowResponse(Parcel in) {
        this.tvId = in.readString();
        this.poster = in.readString();
        this.name = in.readString();
        this.releaseDate = in.readString();
        this.language = in.readString();
        this.rating = in.readDouble();
        this.overview = in.readString();
    }

    public static final Parcelable.Creator<TVShowResponse> CREATOR = new Parcelable.Creator<TVShowResponse>() {
        @Override
        public TVShowResponse createFromParcel(Parcel source) {
            return new TVShowResponse(source);
        }

        @Override
        public TVShowResponse[] newArray(int size) {
            return new TVShowResponse[size];
        }
    };
}
