package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import fr.whatscook.wc.RequeteServeur;
import fr.whatscook.wc.R;

/**
 * Created by hilmoinb on 11/03/15.
 */
public class FragmentRecettes extends Fragment {
    SearchView search;

    ListView lv ;
    String recherchemot="";

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_recettes, container, false);
        search=(SearchView) rootView.findViewById(R.id.searchView);
        search.setQueryHint("ingredients, plats..");
     //   search.setIconifiedByDefault(false);
        lv = (ListView)rootView.findViewById(R.id.listeRecherche);



        //*** setOnQueryTextListener ***
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
               // TODO Auto-generated method stub
              try {

                 recherchemot=query;
                 new JSONParse().execute();


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


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
               FragmentManager fm = getFragmentManager();
                if (fm != null) {
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frame_container, new ResultatRecherche(lv.getItemAtPosition(position).toString()));
                    ft.commit();
                }
            }
        });
        return rootView;
    }
    private class JSONParse extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected String doInBackground(String... args) {
            RequeteServeur t = new RequeteServeur();
            // Getting JSON from URL
            String s = t.getJSONFromUrl("http://bouleau25.iut-infobio.priv.univ-lille1.fr:8080/v1/cook/recherche/"+recherchemot);
            return s;
        }
        @Override
        protected void onPostExecute(String json) {
          // Getting JSON Array
            try {
                String res[]=json.split("---");

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, res);
              //  ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_recettes,R.id.textView2, res);
                lv.setAdapter(adapter);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}





