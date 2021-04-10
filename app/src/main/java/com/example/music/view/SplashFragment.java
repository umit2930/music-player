package com.example.music.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.music.R;
import com.example.music.databinding.FragmentSplashBinding;

public class SplashFragment extends Fragment {

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_splash,container,false);
        FragmentSplashBinding binding=FragmentSplashBinding.inflate(getLayoutInflater());
        binding.getRoot();
        return view;
    }
}
