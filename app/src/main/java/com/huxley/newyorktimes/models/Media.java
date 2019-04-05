package com.huxley.newyorktimes.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Media implements Parcelable {

    private String type;
    private String caption;
    @SerializedName(value = "media-metadata")
    private ArrayList<MediaMetaData> metadata;

    protected Media(Parcel in) {
        type = in.readString();
        caption = in.readString();
        metadata = in.createTypedArrayList(MediaMetaData.CREATOR);
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel in) {
            return new Media(in);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ArrayList<MediaMetaData> getMetadata() {
        return metadata;
    }

    public void setMetadata(ArrayList<MediaMetaData> metadata) {
        this.metadata = metadata;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(caption);
        dest.writeTypedList(metadata);
    }
}
