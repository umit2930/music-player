package com.example.music.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;
import com.example.music.databinding.ItemFavorateBinding;
import com.example.music.databinding.ItemPlayListBinding;
import com.example.music.viewmodel.ViewModelItemFavoriteModel;
import com.example.music.viewmodel.ViewModelPlayListModel;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.VH> {


    private ArrayList<ViewModelItemFavoriteModel> arrayList=new ArrayList<>();
    Context context;

    private LayoutInflater layoutInflater;


    public FavoriteAdapter(ArrayList<ViewModelItemFavoriteModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater==null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemFavorateBinding itemUserBinding= DataBindingUtil.inflate(layoutInflater, R.layout.item_favorate,parent,false);

        return new VH(itemUserBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bind(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        ItemFavorateBinding itemFavorateBinding;
        public VH(@NonNull ItemFavorateBinding itemFavorateBinding) {
            super(itemFavorateBinding.getRoot());
            this.itemFavorateBinding=itemFavorateBinding;
        }

        private void bind(ViewModelItemFavoriteModel userViewModel){
            this.itemFavorateBinding.setViewModel(userViewModel);
            this.itemFavorateBinding.executePendingBindings();


        }

        public ItemFavorateBinding getItemUserBinding() {
            return itemFavorateBinding;
        }
    }
}
