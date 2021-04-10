package com.example.music.remote.databasetext;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities =  {TextModel.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TextModelDao TextDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context){

        if (INSTANCE == null ){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class ,"text"
            ).allowMainThreadQueries().build();
        }

        return INSTANCE;
    }
}
