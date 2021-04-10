package com.example.music.remote.databasetext;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TextModel {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "text")
    public String name;

    @ColumnInfo(name = "eng")
    public String eng;

    @ColumnInfo(name = "persian")
    public String persian;


}
