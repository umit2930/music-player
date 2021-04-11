package com.example.music.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.music.R;
import com.example.music.remote.databasetext.AppDatabase;
import com.example.music.remote.databasetext.TextModel;
import com.example.music.sharedprefrences.MusicSharedPerf;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTextApp();
        setContentView(R.layout.activity_main);


    }

    private void setTextApp() {
        if (!new MusicSharedPerf(getApplicationContext()).Text()){
            saveUser("appVersion","1.0.0","1.0.0");
            saveUser("appName","musicPlayer","موزیک پخش کن");
            saveUser("playList","playList","لیست پخش");
            saveUser("favorite","favorite","ذخیره شده");
        }
    }


    private void saveUser(String name, String english,String persian) {

        AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());

        TextModel textModel = new TextModel();
        textModel.name = name;
        textModel.eng = english;
        textModel.persian=persian;

        db.TextDao().insertText(textModel);

    }
}