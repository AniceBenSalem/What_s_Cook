package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.whatscook.wc.R;

/**
 * Created by hilmoinb on 11/03/15.
 */
public class FragmentEvenements extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_evenements, container, false);

        return rootView;
    }
}

