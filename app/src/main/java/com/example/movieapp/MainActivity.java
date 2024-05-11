package com.example.movieapp;

import android.content.Intent;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.movieapp.Fragments.TVSeries;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewpager;


    RecyclerView Recyclerview;
    FirebaseDatabase firebaseDatabase;
    List<Movie> Movielist=new ArrayList<>();
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        navigationView = findViewById(R.id.navview);
        drawerLayout = findViewById(R.id.drawer);

        //adding customised toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //toggle button
        actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //when an item is selected from menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                int id=item.getItemId();
                if (id==R.id.nav_camera) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    //close drawer
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (id==R.id.nav_telegram) {
                  /*  Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("https://web.telegram.org/a/"));
                    startActivity(i);*/


                  /*  Intent telegram = new Intent(android.content.Intent.ACTION_SEND);
                    telegram.setData(Uri.parse("https://web.telegram.org/a/"));
                    telegram.setPackage("org.telegram.messenger");
                    startActivity(Intent.createChooser(telegram, "Share with"));*/

                   String userid = "https://web.telegram.org/a/";
                    Intent tgintent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("tg://openmessage?user_id=" + userid));
                    tgintent.setPackage("org.telegram.messenger");
                    startActivity(tgintent);


                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(getApplicationContext(), "Telegram", Toast.LENGTH_SHORT).show();
                } else if (id==R.id.nav_share) {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = "Here is the share content body";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sharingIntent, "Share via"));

                } else if (id==R.id.nav_livetv) {
                    Intent inten=new Intent(MainActivity.this, VideoPlayer.class);
                    startActivity(inten);

                }
                return true;
            }
        });

        tabLayout=findViewById(R.id.tabLayout);
        viewpager=findViewById(R.id.viewpager);

        ViePagerAdapter viePagerAdapter=new ViePagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(viePagerAdapter);
        tabLayout.setupWithViewPager(viewpager);



        FirebaseApp.initializeApp(this);


        }
}