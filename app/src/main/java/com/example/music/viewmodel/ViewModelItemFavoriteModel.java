package com.example.music.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.music.model.Audio;

public class ViewModelItemFavoriteModel extends BaseObservable {

    private String path;
    private String name;
    private String album;
    private String artist;

    public ViewModelItemFavoriteModel(Audio audio) {
        this.path = audio.getPath();
        this.name = audio.getName();
        this.album = audio.getAlbum();
        this.artist = audio.getArtist();
    }


    @Bindable
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

}
