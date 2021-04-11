package com.example.music.viewmodel;

import android.content.Context;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.music.remote.databasetext.AppDatabase;
import com.example.music.remote.databasetext.TextModel;
import com.example.music.sharedprefrences.MusicSharedPerf;

import java.util.Locale;

public class ViewModelSplash  extends BaseObservable {

    public String appName;
    public String appVersion;
    Context context;

    public ViewModelSplash (Context context){
        this.context=context;

        getText();
    }

    private void getText() {
        AppDatabase db = AppDatabase.getDbInstance(context);

        if (Locale.getDefault().getDisplayLanguage().equals("فارسی")){
            appName=((TextModel)db.TextDao().findByLan("appName").get(0)).persian;
            appVersion=((TextModel)db.TextDao().findByLan("appVersion").get(0)).persian;
        }else {

            appName=((TextModel)db.TextDao().findByLan("appName").get(0)).eng;
            appVersion=((TextModel)db.TextDao().findByLan("appVersion").get(0)).eng;
        }

    }

    @Bindable
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Bindable
    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
