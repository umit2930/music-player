package com.example.music.viewmodel;

import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;

public class ViewModelHomeFragment extends ViewModel {


    private String playList;
    private String appName;
    private String favorite;
    private String hintSearch;




    public ViewModelHomeFragment() {
        //rome get text
    }


    @Bindable
    public String getHintSearch() {
        return hintSearch;
    }

    public void setHintSearch(String hintSearch) {
        this.hintSearch = hintSearch;
    }

    @Bindable
    public String getPlayList() {
        return playList;
    }

    public void setPlayList(String playList) {
        this.playList = playList;
    }

    @Bindable
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }


    @Bindable
    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }
}
