package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

import fr.whatscook.wc.R;

/**
 * Created by hilmoinb on 11/03/15.
 */
public class FragmentFrigo extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_frigo, container, false);
        Spinner sp = (Spinner) rootView.findViewById(R.id.Trier);
        ArrayAdapter adTerminal = ArrayAdapter.createFromResource(getActivity(), R.array.trier, android.R.layout.simple_spinner_item) ;
        sp.setAdapter(adTerminal);
        final ListView lv = (ListView)rootView.findViewById(R.id.listFrigo);
        final ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.frigo, android.R.layout.simple_spinner_item);
        lv.setAdapter(adapter);

        return rootView;
    }
}
