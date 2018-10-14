package com.marcoryan.guessmygas;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Trips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        this.setTitle("Trips");

        final Button trip_button1 = findViewById(R.id.trip_button1);
        trip_button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(Trips.this, TripDetails.class));
            }
        });

        final Button trip_button2 = findViewById(R.id.trip_button2);
        trip_button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(Trips.this, TripDetails.class));
            }
        });

        final Button trip_button3 = findViewById(R.id.trip_button3);
        trip_button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(Trips.this, TripDetails.class));
            }
        });
    }
}
