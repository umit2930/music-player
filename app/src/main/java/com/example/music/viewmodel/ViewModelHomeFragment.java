package com.example.music.viewmodel;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.telecom.Connection;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.model.Audio;
import com.example.music.model.PlayListModel;
import com.example.music.remote.databasetext.AppDatabase;
import com.example.music.remote.databasetext.TextModel;
import com.example.music.view.adapter.FavoriteAdapter;
import com.example.music.view.adapter.PlayListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;

public class ViewModelHomeFragment extends BaseObservable {


    private String playList;
    private String appName;
    private String favorite;
    private String hintSearch;
    public static Context context;

    public static View view;

    private ArrayList<ViewModelPlayListModel> arrayList=new ArrayList<>();
    private ArrayList<ViewModelItemFavoriteModel> arrayListFavorite=new ArrayList<>();




    private MutableLiveData<ArrayList<ViewModelPlayListModel>> mutableLiveData=new MutableLiveData<>();

    private MutableLiveData<ArrayList<ViewModelItemFavoriteModel>> mutableLiveDataFavorite=new MutableLiveData<>();








    public ViewModelHomeFragment(Context context,View view) {
        //rome get text
        this.context=context;
        getText();

        this.view=view;
        test();
    }

    private void test() {


        ViewModelPlayListModel viewModelPlayListModel;
        for (int i=0;i<10;i++){
            PlayListModel playListModel=new PlayListModel();
            playListModel.setCount(10);
            playListModel.setImage("kdjcjdkc");
            playListModel.setId(i);
            playListModel.setName("can i help you");
            viewModelPlayListModel= new ViewModelPlayListModel(playListModel);
            arrayList.add(viewModelPlayListModel);

        }
        mutableLiveData.setValue(arrayList);


        getAudioList();

    }

    private void getAudioList() {
        try {
            Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.AudioColumns.ALBUM, MediaStore.Audio.ArtistColumns.ARTIST,};
            String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
            String sortOrder = MediaStore.Audio.Media.TITLE + " ASC";
            Cursor c = context.getApplicationContext().getContentResolver().query(uri, projection, selection, null, sortOrder);


            Toast.makeText(context, ""+c.getCount(), Toast.LENGTH_SHORT).show();

            System.out.println("-------------------:"+c);
            if (c != null) {
                while (c.moveToNext()) {
                    Audio audioModel = createAudioModel(c);
                    ViewModelItemFavoriteModel viewModelItemFavoriteModel=new ViewModelItemFavoriteModel(audioModel);
                    arrayListFavorite.add(viewModelItemFavoriteModel);
                }
                c.close();
            }
        } catch (SecurityException e) {

        }

        mutableLiveDataFavorite.setValue(arrayListFavorite);

    }

    private Audio createAudioModel(Cursor c) {
        String path = c.getString(0);
        String album = c.getString(1);
        String artist = c.getString(2);
        String name = path.substring(path.lastIndexOf("/") + 1);
        Audio audioModel = new Audio();
        audioModel.setPath(path);
        audioModel.setAlbum(album);
        audioModel.setArtist(artist);
        audioModel.setName(name);

        return audioModel;
    }



    private void getText() {

        AppDatabase db = AppDatabase.getDbInstance(context);


        if (Locale.getDefault().getDisplayLanguage().equals("فارسی")){

            playList=((TextModel)db.TextDao().findByLan("playList").get(0)).persian;
            appName=((TextModel)db.TextDao().findByLan("appName").get(0)).persian;
            favorite=((TextModel)db.TextDao().findByLan("favorite").get(0)).persian;

        }else {

            playList=((TextModel)db.TextDao().findByLan("playList").get(0)).eng;
            appName=((TextModel)db.TextDao().findByLan("appName").get(0)).eng;
            favorite=((TextModel)db.TextDao().findByLan("favorite").get(0)).eng;



        }
    }

    @BindingAdapter("bind:recyclerViewPlayList")
    public static void recyclerViewBinding(RecyclerView recyclerView, MutableLiveData<ArrayList<ViewModelPlayListModel>> arrayListMutableLiveData)
    {
        arrayListMutableLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<ArrayList<ViewModelPlayListModel>>() {
            @Override
            public void onChanged(ArrayList<ViewModelPlayListModel> userViewModels) {
                PlayListAdapter adapter=new PlayListAdapter(userViewModels,context);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL,false ));
                recyclerView.setAdapter(adapter);

            }
        });




    }

    @BindingAdapter("bind:recyclerViewPlayList")
    public static void recyclerViewBindingFavorite(RecyclerView recyclerView, MutableLiveData<ArrayList<ViewModelItemFavoriteModel>> arrayListMutableLiveData)
    {
        arrayListMutableLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<ArrayList<ViewModelItemFavoriteModel>>() {
            @Override
            public void onChanged(ArrayList<ViewModelItemFavoriteModel> userViewModels) {
                FavoriteAdapter adapter=new FavoriteAdapter(userViewModels,context);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL,false ));
                recyclerView.setAdapter(adapter);

            }
        });




    }

    public MutableLiveData<ArrayList<ViewModelPlayListModel>> getMutableLiveData() {
        return mutableLiveData;
    }
    public MutableLiveData<ArrayList<ViewModelItemFavoriteModel>> getMutableLiveDataFavorite() {
        return mutableLiveDataFavorite;
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
