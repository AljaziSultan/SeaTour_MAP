package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.fragment.app.Fragment;


import com.example.logsignsql.databinding.CategoriesFragmentBinding;

import java.util.ArrayList;
public class CategoriesActivity extends Fragment {
    View view;
    CategoriesFragmentBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =CategoriesFragmentBinding.inflate(getLayoutInflater());
        // view = inflater.inflate(R.layout.profile_fragment, container, false);
        view = binding.getRoot();
        int[] imageList = {R.drawable.pasta, R.drawable.maggi, R.drawable.cake, R.drawable.pancake, R.drawable.pizza, R.drawable.burger, R.drawable.fries};
        int[] ingredientList = {R.string.pastaIngredients, R.string.maggiIngredients,R.string.cakeIngredients,R.string.pancakeIngredients,R.string.pizzaIngredients, R.string.burgerIngredients, R.string.friesIngredients};
        int[] descList = {R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc,R.string.pancakeDesc,R.string.pizzaDesc, R.string.burgerDesc, R.string.friesDesc};
        String[] nameList = {"Dana marina", "Fishing trip", "Jubail Sea", "Jana", "Podel"," Boat RIV", "CC Trip"};
        String[] timeList = {" 150 riyals", "120 riyals", "180 riyals","300 riyals", "180 riyals", "120 riyals", "180 riyals"};
        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(getContext(), dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
        return view;
    }
}