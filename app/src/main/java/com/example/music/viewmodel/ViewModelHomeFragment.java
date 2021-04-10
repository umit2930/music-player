package com.example.music.viewmodel;

import android.content.Context;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;

import com.example.music.remote.databasetext.AppDatabase;
import com.example.music.remote.databasetext.TextModel;

import java.util.Locale;
import java.util.Observable;

public class ViewModelHomeFragment extends BaseObservable {


    private String playList;
    private String appName;
    private String favorite;
    private String hintSearch;
    private Context context;




    public ViewModelHomeFragment(Context context) {
        //rome get text
        this.context=context;
        getText();
        System.out.println("--------:"+ Locale.getDefault().getDisplayLanguage());
    }

    private void getText() {

        AppDatabase db = AppDatabase.getDbInstance(context);


        if (Locale.getDefault().getDisplayLanguage().equals("فارسی")){

        }else {

            playList=((TextModel)db.TextDao().findByLan("playList").get(0)).eng;



        }
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
