package fr.whatscook.wc.Fragments;

/**
 * Created by hilmoinb on 11/03/15.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.whatscook.wc.HttpGetRecette;
import fr.whatscook.wc.HttpGetTitreRecette;
import fr.whatscook.wc.R;

public class FragmentAcceuil extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_acceuil, container, false);
        TextView textView = (TextView)rootView.findViewById(R.id.textView4);
        TextView textView2 = (TextView)rootView.findViewById(R.id.textView);
        new HttpGetTitreRecette().execute(textView2);
        new HttpGetRecette().execute(textView);

        return rootView;
    }
}