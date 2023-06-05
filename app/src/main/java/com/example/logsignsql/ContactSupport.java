package com.example.logsignsql;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;



public class ContactSupport extends Fragment {
    Button btn;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_messages);
//        btn= findViewById(R.id.btn);
        view = inflater.inflate(R.layout.fragment_messages, container, false);
         btn = view.findViewById(R.id.btnUpdate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                Uri uri = Uri.parse("mailto:Mahamrash@gmail.com");
                i.setData(uri);
                i.putExtra(Intent.EXTRA_EMAIL  ,"");
                i.putExtra(Intent.EXTRA_SUBJECT, "Customer Service");
                i.putExtra(Intent.EXTRA_TEXT   , "");
                startActivity(i);
            }
        });


        return view;
    }

}