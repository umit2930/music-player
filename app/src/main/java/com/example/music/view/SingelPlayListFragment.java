package com.example.music.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.music.databinding.FragmentSingelPlayListBinding;

public class SingelPlayListFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentSingelPlayListBinding fragmentSingelPlayListBinding=FragmentSingelPlayListBinding.inflate(getLayoutInflater());
        return fragmentSingelPlayListBinding.getRoot();
    }
}
