package com.marcoryan.guessmygas;

import android.os.Bundle;
import androidx.annotation.NonNull;

import com.google.android.gms.maps.MapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    final Fragment mapFragment = new MapFrag();
    final Fragment tripsFragment = new TripsFragment();
    final Fragment settingsFragment = new SettingsFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = tripsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        fm.beginTransaction().add(R.id.main_container, mapFragment).hide(mapFragment).commit();
        fm.beginTransaction().add(R.id.main_container, tripsFragment).commit();
        fm.beginTransaction().add(R.id.main_container, settingsFragment).hide(settingsFragment).commit();

        // handle bottom navigation clicks
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottom_bar_item_map:
                                fm.beginTransaction().hide(active).show(mapFragment).commit();
                                active = mapFragment;
                                return true;

                            case R.id.bottom_bar_item_trips:
                                fm.beginTransaction().hide(active).show(tripsFragment).commit();
                                active = tripsFragment;
                                return true;

                            case R.id.bottom_bar_item_settings:
                                fm.beginTransaction().hide(active).show(settingsFragment).commit();
                                active = settingsFragment;
                                return true;
                        }
                        return false;
                    }
                });


    }
}

