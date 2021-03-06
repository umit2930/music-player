package com.example.music.view;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.music.R;
import com.example.music.databinding.FragmentSplashBinding;
import com.example.music.viewmodel.ViewModelSplash;

public class SplashFragment extends Fragment {

    FragmentSplashBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentSplashBinding.inflate(getLayoutInflater());

        ViewModelSplash viewModelSplash=new ViewModelSplash(getContext());
        binding.setViewModel(viewModelSplash);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        new CountDownTimer(4000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_splashFragment_to_homeFragment);
            }
        }.start();
    }
}
