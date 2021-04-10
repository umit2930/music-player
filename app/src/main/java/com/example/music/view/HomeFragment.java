package com.example.music.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.music.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding=FragmentHomeBinding.inflate(getLayoutInflater());

//        binding.lParent.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        return binding.getRoot();
    }
}
