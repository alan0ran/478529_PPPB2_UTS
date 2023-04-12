package com.example.a478529_pppb2_uts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class SimpleFragment extends Fragment {

    public SimpleFragment() {
        // Required empty public constructor
    }
    public static SimpleFragment newInstance(){
        return new SimpleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
        return rootView;
    }
}