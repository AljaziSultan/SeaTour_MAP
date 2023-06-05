package com.example.logsignsql;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

/*
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
*/
public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawerLayout;
   // ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton fab;

    ImageView twitter, instagram, linked;

    Intent Home=new Intent(getBaseContext(), HomeActivity.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityhome);
//        setContentView(R.layout.home_fragment);

        twitter=findViewById(R.id.twitter);
        instagram=findViewById(R.id.insta);
        linked=findViewById(R.id.linkedinn);
        //////////////////////////////////////////////////////////
        fab = findViewById(R.id.faby);
        bottomNavigationView=findViewById(R.id.BottomNavigationView);
        drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView Nav_view = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        /////////////////////////////////////////////////////////
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//
//        if (savedInstanceState == null) {
//         getSupportActivityManager().beginTransaction().replace(R.id.frame_layout, new HomeActivity()).commit();
//            Nav_view.setCheckedItem(R.id.Homeitem);
//        }
       Nav_view.setNavigationItemSelectedListener(this);



        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sWebLink="https://twitter.com/SeaTour364899";
                openLink(sWebLink);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sWebLink="https://www.instagram.com/seatourtrips";
                openLink(sWebLink);
            }
        });

        linked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sWebLink="https://www.linkedin.com/in/sea-tour-647836278/";
                openLink(sWebLink);
            }
        });
       bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.faby:

                    //startActivity(Home);
                    break;
//                case R.id.Searchitem:
//                    Intent search=new Intent(getBaseContext(),SearchFragment.class);
//                    startActivity(search);
//                    break;
                case R.id.Proitem:
                    replaceFragement(new ProfileFragment());
                    break;

//                case R.id.Cart_item:
//                    Intent calendar =new Intent(getBaseContext(),CalendarActivity.class);
//                    startActivity(calendar);
//                    break;

                case R.id.Chatitem:
//                    Intent ContactSupport =new Intent(getBaseContext(),ContactSupport.class);
//                    startActivity(ContactSupport);
                    replaceFragement(new ContactSupport());
                    break;
                default:
                    break;

            }

           return true;
            });
            fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(Home);
            }
       });


        /////////////////////////////////////////////////////////


    }

    private void openLink(String sWebLink){
        Uri uri=Uri.parse(sWebLink);
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);}



    private void getSupportActivityManager() {
        /* return null; */
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case
                    R.id.Homeitem:
                //Intent Home=new Intent(getBaseContext(),MainActivity.class);
                startActivity(Home);
              //  replaceFragement(new HomeFragment());
            break;
            case
                    R.id.Catitem:
                replaceFragement(new CategoriesActivity());
//                Intent category=new Intent(getBaseContext(),CategoriesActivity.class);
//                startActivity(category);
            break;
//            case
//                    R.id.BookMapitem:
//               // replaceFragement(new BookFragment());
//                break;
//            case
//                    R.id.QuicKSearchitem:
//                Intent search=new Intent(getBaseContext(),SearchFragment.class);
//                startActivity(search);//
//                break;

            case
                    R.id.ContactUsitem:
              replaceFragement(new ContactSupport());
//                Intent ContectSupport=new Intent(getBaseContext(),HomeActivity.class);
//                startActivity(ContectSupport);
                break;
            case
                    R.id.LogOutitem:
//                Toast.makeText(this,"Logout!", Toast.LENGTH_LONG).show();
               /// replaceFragement(new LogOutFragment());
                Intent Logout =new Intent(getBaseContext(),MainActivity.class);
          startActivity(Logout);
                break;

            case
                    R.id.Profileitem:
           replaceFragement(new ProfileFragment());
                break;

            case
                    R.id.Calendaritem:
                replaceFragement(new CalendarActivity());
//                Intent calendar =new Intent(getBaseContext(),CalendarActivity.class);
//                startActivity(calendar);
                break;
            default:
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);

        else
            super.onBackPressed();

    }

/*
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BottomNavigationView.setBackground(null);
   binding.BottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.fab:
                    replaceFragement(new HomeFragment());
                    break;
                case R.id.Searchitem:
                    replaceFragement(new SearchFragment());
                    break;
                case R.id.Proitem:
                    replaceFragement(new ProfileFragment());
                    break;

                case R.id.Cart_item:
                    replaceFragement(new CartFragment());
                    break;

                case R.id.Chatitem:
                    replaceFragement(new MessagesFragment());
                    break;
                default:
                    break;

            }


            return true;
        });
   */



    //Outside Oncreate

           /* private void showBottomDialog() {

            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.bottomsheetlayout);

            LinearLayout upload = dialog.findViewById(R.id.Upload);
           // LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
           // LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
            ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

            upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                    Toast.makeText(MainActivity.this,"Upload an image or a video",Toast.LENGTH_SHORT).show();

                }
            });


            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.getWindow().setGravity(Gravity.BOTTOM);

        }

            */
    private void replaceFragement(Fragment fragement)
    {
        FragmentManager fragementmanager = getSupportFragmentManager();
        FragmentTransaction fragementTransction = fragementmanager.beginTransaction();
        fragementTransction.replace(R.id.frame_layout, fragement);
        fragementTransction.commit();

    }



}