package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.whatscook.wc.R;

/**
 * Created by Benjamin on 14/03/2015.
 */
public class FragmentCompte extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.creer_compte, container, false);

        return rootView;
    }
}