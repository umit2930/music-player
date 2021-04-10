package com.example.music.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import com.example.music.remote.databasetext.AppDatabase;
import com.example.music.remote.databasetext.TextModel;
import com.example.music.sharedprefrences.MusicSharedPerf;

public class ViewModelSplash  extends BaseObservable {

    Context context;
    public ViewModelSplash (Context context){
        this.context=context;
        if (!new MusicSharedPerf(context).Text()){
            saveUser("appName","musicPlayer","موزیک پخش کن");
            saveUser("playList","playList","لیست پخش");
            saveUser("favorite","favorite","ذخیره شده");
        }
    }

    private void saveUser(String name, String english,String persian) {

        AppDatabase db = AppDatabase.getDbInstance(context);

        TextModel textModel = new TextModel();
        textModel.name = name;
        textModel.eng = english;
        textModel.persian=persian;

        db.TextDao().insertText(textModel);

    }
}
