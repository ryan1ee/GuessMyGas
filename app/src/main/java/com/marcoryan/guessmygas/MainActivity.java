package com.marcoryan.guessmygas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.SharedPreferences;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//
//    private TextView mTextMessage;
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    Snackbar.make(findViewById(android.R.id.content), "Welcome to Dashboard!", Snackbar.LENGTH_LONG).show();
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    Snackbar.make(findViewById(android.R.id.content), "Welcome to Notifications!", Snackbar.LENGTH_LONG).show();
//                    return true;
//            }
//            return false;
//        }
//    };

    private static final String TAG_FRAGMENT_MAP = "tag_frag_map";
    private static final String TAG_FRAGMENT_TRIPS = "tag_frag_trips";
    private static final String TAG_FRAGMENT_SETTINGS = "tag_frag_settings";

    private BottomNavigationView bottomNavigationView;

    private List<BottomBarFragment> fragments = new ArrayList<>(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        configureTripsButton();

        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.bottombaritem_map:
                                switchFragment(0, TAG_FRAGMENT_MAP);
                                return true;


                            case R.id.bottombaritem_trips:
                                switchFragment(1, TAG_FRAGMENT_TRIPS);
                                return true;

                            case R.id.bottombaritem_settings:
                                switchFragment(2, TAG_FRAGMENT_SETTINGS);
                                return true;
                        }
                        return false;
                    }
                });

        buildFragmentsList();

        switchFragment(0, TAG_FRAGMENT_TRIPS);

//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        final EditText mEditText1 = findViewById(R.id.editText1);
//        final EditText mEditText2 = findViewById(R.id.editText2);
//
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                // Code here executes on main thread after user presses button
//                try {
//                    storeMileage(Float.parseFloat(mEditText1.getText().toString()));
//                } catch (NumberFormatException e) {
//                    throw e;
//                } finally {
//                    storeName(mEditText2.getText().toString());
//            }
//        });
//
//        Button button2 = findViewById(R.id.button2);
//        button2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                // Code here executes on main thread after user presses button
//                getMileage();
//                getName();
//            }
//        });
    }

    private void buildFragmentsList() {
        BottomBarFragment mapFragment = buildFragment("Map");
        BottomBarFragment tripsFragment = buildFragment("Trips");
        BottomBarFragment settingsFragment = buildFragment("Settings");

        fragments.add(mapFragment);
        fragments.add(tripsFragment);
        fragments.add(settingsFragment);
    }

    private BottomBarFragment buildFragment(String title) {
        BottomBarFragment fragment = new BottomBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BottomBarFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_fragmentholder, fragments.get(pos), tag)
                .commit();
    }

    private float getMileage() {
        SharedPreferences pref = getSharedPreferences("GMG_mileage", MODE_PRIVATE);
        Float mileage = pref.getFloat("mileage", 0);
        System.out.println(mileage);
        return mileage;
    }

    private void storeMileage(Float mileage) {
            SharedPreferences pref = getSharedPreferences("GMG_mileage", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putFloat("mileage", mileage);
            editor.apply();

    }

    private void storeName(String name) {
        SharedPreferences pref = getSharedPreferences("GMG_username", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("username", name);
        editor.apply();
    }

    private String getName() {
        SharedPreferences pref = getSharedPreferences("GMG_username", MODE_PRIVATE);
        String name = pref.getString("username", "Username not found!");
        System.out.println(name);
        return name;
    }
//
//    private void configureTripsButton() {
//        Button tripButton = (Button) findViewById(R.id.button3);
//        tripButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, Trips.class));
//            }
//        });
//    }

}