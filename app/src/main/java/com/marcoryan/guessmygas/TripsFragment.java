package com.marcoryan.guessmygas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class TripsFragment extends Fragment {


    public TextView t;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.trips_fragment, container, false);

        t = rootView.findViewById(R.id.TRIP_TEXT);
        t.setText("TRIPS");

        return rootView;
    }

}
