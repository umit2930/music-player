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

import java.util.List;

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.VH> {

    ViewModelHomeFragment viewModel;
    List<PlayListModel> listModels;
    Context context;

    View view;

    public PlayListAdapter(ViewModelHomeFragment viewModel, List<PlayListModel> listModels, Context context) {
        this.viewModel = viewModel;
        this.listModels = listModels;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_play_list,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VH extends RecyclerView.ViewHolder {
        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
