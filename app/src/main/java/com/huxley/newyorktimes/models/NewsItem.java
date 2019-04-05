package com.huxley.newyorktimes.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class NewsItem implements Parcelable {


    private String byline;
    private String title;
    private String published_date;
    private ArrayList<Media> media;
    @SerializedName(value = "abstract")
    private String details;


    protected NewsItem(Parcel in) {
        byline = in.readString();
        title = in.readString();
        published_date = in.readString();
        media = in.createTypedArrayList(Media.CREATOR);
        details = in.readString();
    }

    public static final Creator<NewsItem> CREATOR = new Creator<NewsItem>() {
        @Override
        public NewsItem createFromParcel(Parcel in) {
            return new NewsItem(in);
        }

        @Override
        public NewsItem[] newArray(int size) {
            return new NewsItem[size];
        }
    };

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(byline);
        dest.writeString(title);
        dest.writeString(published_date);
        dest.writeTypedList(media);
        dest.writeString(details);
    }
}
