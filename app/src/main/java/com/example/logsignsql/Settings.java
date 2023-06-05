package com.example.logsignsql;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class Settings extends Fragment {
    TextView tv_name;
    Switch switch_id;
    Activity activity;
    @SuppressLint("MissingInflatedId")
    @Override
    //link with logIn page:
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.settings, container, false);
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
       /// tv_name=findViewById(R.id.textView);
       TextView tv_name = view.findViewById(R.id.textView);
        TextView lan = view.findViewById(R.id.Languageext);
        Intent i=getActivity().getIntent();
        String name=i.getStringExtra("User_name");
        tv_name.setText(name);

        loadLocale();
        //setContentView(R.layout.activity_main);
        // change actionbar title ,if you dont change it will be according to your system default language/english
        ActionBar acitonBar = ((AppCompatActivity) activity).getSupportActionBar();
        acitonBar.setTitle(getResources().getString(R.string.app_name));


        lan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show alert Dialog to display list of language

                showLanDialog();
            }
        });

        switch_id = view.findViewById(R.id.SwitchNight);
        switch_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO)
                if (switch_id.isChecked()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                }
            }
        });
        return view;
    }

    private void showLanDialog()
    {
        final String [] listItems = {"Arabic","English"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder( getActivity());
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0){
                    setLocale("ar-rSA");
                    getActivity().recreate();
                }
                else if (i == 1){
                    setLocale("en-rUS");
                    getActivity().recreate();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog mDialod = mBuilder.create();
        mDialod.show();
    }

    private void setLocale(String langs) {
        Locale locale=new Locale(langs);
        Locale.setDefault(locale);
        Configuration config=new Configuration();
        config.locale =locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());
        //save date to shared preferences
        SharedPreferences.Editor editor= getActivity().getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", langs);
        editor.apply();
    }

    //load languages saned in shared preferences

    public void loadLocale (){
        SharedPreferences prefe = getActivity().getSharedPreferences( "Settings", MODE_PRIVATE);
        String Language = prefe.getString("My_Lang", "");
        setLocale(Language);
    }

}