package com.example.music.remote.databasetext;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public  interface TextModelDao {

    @Query("SELECT * FROM TextModel WHERE text IN(:name)")
    public abstract List<TextModel> findByLan(String name);

    @Insert
    void insertText(TextModel... textModels);

    @Delete
    abstract void delete(TextModel textModel) ;


}
