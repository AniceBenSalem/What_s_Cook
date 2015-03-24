package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.whatscook.wc.HttpGetTitreRecette;
import fr.whatscook.wc.R;

/**
 * Created by hilmoinb on 11/03/15.
 */
public class FragmentRecettes extends Fragment {
    SearchView search;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_recettes, container, false);
        search=(SearchView) rootView.findViewById(R.id.searchView);
        search.setQueryHint("ingredients, plats..");

        //*** setOnQueryTextFocusChangeListener ***
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });

        //*** setOnQueryTextListener ***
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
               // TODO Auto-generated method stub
              try {
                    TextView dd= (TextView) rootView.findViewById(R.id.textView2);
                  String[] countryArray = dd.getText().toString().split(" ") ;
                  ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_recettes,R.id.textView2, countryArray);
                  ListView lv = (ListView)rootView.findViewById(R.id.listeRecherche);
                  lv.setAdapter(adapter);




              }catch (Exception e){
                e.getStackTrace();
              }
                 return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return rootView;
    }

}




