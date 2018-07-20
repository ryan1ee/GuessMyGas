package com.marcoryan.guessmygas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.support.design.widget.Snackbar;
import android.support.design.widget.BaseTransientBottomBar;
import android.widget.Button;
import android.view.View;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    Snackbar.make(findViewById(android.R.id.content), "Welcome to Dashboard!", Snackbar.LENGTH_LONG).show();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    Snackbar.make(findViewById(android.R.id.content), "Welcome to Notifications!", Snackbar.LENGTH_LONG).show();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final EditText mEditText1 = findViewById(R.id.editText1);
        final EditText mEditText2 = findViewById(R.id.editText2);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Code here executes on main thread after user presses button
                storeMileage(Float.parseFloat(mEditText1.getText().toString()));
                storeName(mEditText2.getText().toString());
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Code here executes on main thread after user presses button
                getMileage();
                getName();
            }
        });
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
}