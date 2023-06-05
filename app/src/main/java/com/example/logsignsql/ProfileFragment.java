package com.example.logsignsql;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class ProfileFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        final Button btnDelete = view.findViewById(R.id.btnDelete);
        final Button btnEdit = view.findViewById(R.id.btnUpdate);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view);

            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragement(new EditProfile());
            }
        });
        return view;
    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete User Account");
        builder.setMessage("Are you sure you want to delete Your Account?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //لحذف  من قاعدة البيانات
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }
    private void replaceFragement(Fragment fragement)
    {
        FragmentManager fragementmanager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragementTransction = fragementmanager.beginTransaction();
        fragementTransction.replace(R.id.frame_layout, fragement);
        fragementTransction.commit();

    }
}