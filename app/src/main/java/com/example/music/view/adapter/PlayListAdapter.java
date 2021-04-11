package com.example.music.view.adapter;

import android.content.Context;
import android.os.Build;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;
import com.example.music.databinding.ItemPlayListBinding;
import com.example.music.model.PlayListModel;
import com.example.music.viewmodel.ViewModelHomeFragment;
import com.example.music.viewmodel.ViewModelPlayListModel;

import java.util.ArrayList;
import java.util.List;

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.VH> {


    private ArrayList<ViewModelPlayListModel> arrayList=new ArrayList<>();
    Context context;

    private LayoutInflater layoutInflater;


    public PlayListAdapter(ArrayList<ViewModelPlayListModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater==null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemPlayListBinding itemUserBinding= DataBindingUtil.inflate(layoutInflater, R.layout.item_play_list,parent,false);

        return new VH(itemUserBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        ItemPlayListBinding itemPlayListBinding;
        public VH(@NonNull ItemPlayListBinding itemPlayListBinding) {
            super(itemPlayListBinding.getRoot());
            this.itemPlayListBinding=itemPlayListBinding;
        }

        private void bind(ViewModelPlayListModel userViewModel){
            this.itemPlayListBinding.setViewModel(userViewModel);
            this.itemPlayListBinding.executePendingBindings();


        }

        public ItemPlayListBinding getItemUserBinding() {
            return itemPlayListBinding;
        }
    }
}
