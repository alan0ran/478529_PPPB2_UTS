package com.example.a478529_pppb2_uts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }
    public static MainFragment newInstance(){
        return new MainFragment(); }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }
}