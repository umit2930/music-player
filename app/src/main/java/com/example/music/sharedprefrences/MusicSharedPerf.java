package com.example.music.sharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;

public class MusicSharedPerf {

    private static final String USER_SHARED_PREF_NAME = "music";
    private SharedPreferences sharedPreferences;

    public MusicSharedPerf(Context context) {
        sharedPreferences=context.getSharedPreferences(USER_SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }


    public boolean Text(){
        return sharedPreferences.getBoolean("text",false);
    }
    public void setText(boolean b){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("text",b);
        editor.apply();
    }
}
