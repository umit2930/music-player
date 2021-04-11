package com.example.music.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.example.music.R;
import com.example.music.remote.databasetext.AppDatabase;
import com.example.music.remote.databasetext.TextModel;
import com.example.music.sharedprefrences.MusicSharedPerf;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTextApp();
        setContentView(R.layout.activity_main);



        ///test get music


        getAudioList();



    }

    private List<MediaStore.Audio> getAudioList() {
        final List<MediaStore.Audio> tempAudioList = new ArrayList<>();
        try {
            Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.AudioColumns.ALBUM, MediaStore.Audio.ArtistColumns.ARTIST,};
            String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
            String sortOrder = MediaStore.Audio.Media.TITLE + " ASC";
            Cursor c = getApplicationContext().getContentResolver().query(uri, projection, selection, null, sortOrder);


            Toast.makeText(this, ""+c.getCount(), Toast.LENGTH_SHORT).show();

            System.out.println("-------------------:"+c);
            if (c != null) {
                while (c.moveToNext()) {
                    MediaStore.Audio audioModel = createAudioModel(c);
                    tempAudioList.add(audioModel);
                }
                c.close();
            }
        } catch (SecurityException e) {

        }
        return tempAudioList;
    }

    private MediaStore.Audio createAudioModel(Cursor c) {
        String path = c.getString(0);
        String album = c.getString(1);
        String artist = c.getString(2);
        String name = path.substring(path.lastIndexOf("/") + 1);
        MediaStore.Audio audioModel = new MediaStore.Audio();

        return audioModel;
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