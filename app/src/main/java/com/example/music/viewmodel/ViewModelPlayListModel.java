package com.example.music.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.music.model.PlayListModel;

public class ViewModelPlayListModel  extends BaseObservable {


    private String name;
    private String imageUrl;
    private int id;
    private String count;


    public ViewModelPlayListModel(PlayListModel playListModel) {
        this.name = playListModel.getName();
        this.imageUrl = playListModel.getImage();
        this.id = playListModel.getId();
        this.count = String.valueOf(playListModel.getCount());
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getCount() {
        return String.valueOf(count);
    }

    public void setCount(String count) {
        this.count = count;
    }


}
