package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.logsignsql.databinding.ActivityDetailedBinding;
//import com.example.seatour.databinding.ActivityDetailedBinding;
public class DetailedActivity extends Fragment {
    ActivityDetailedBinding binding;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
       // setContentView(binding.getRoot());
        view = binding.getRoot();
        Intent intent = getActivity().getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String time = intent.getStringExtra("time");
            int ingredients = intent.getIntExtra("ingredients", R.string.maggiIngredients);
            int desc = intent.getIntExtra("desc", R.string.maggieDesc);
            int image = intent.getIntExtra("image", R.drawable.maggi);
            binding.detailName.setText(name);
            binding.detailTime.setText(time);
            binding.detailDesc.setText(desc);
            binding.detailIngredients.setText(ingredients);
            binding.detailImage.setImageResource(image);
        }
        return view;
    }
}