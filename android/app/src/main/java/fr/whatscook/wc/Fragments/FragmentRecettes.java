package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import fr.whatscook.wc.TitreRecettes;
import fr.whatscook.wc.R;

/**
 * Created by hilmoinb on 11/03/15.
 */
public class FragmentRecettes extends Fragment {
    SearchView search;
    TextView tv;
    ListView lv ;
    String recherchemot="";

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_recettes, container, false);
        search=(SearchView) rootView.findViewById(R.id.searchView);
        search.setQueryHint("ingredients, plats..");
        search.setIconifiedByDefault(false);
        lv = (ListView)rootView.findViewById(R.id.listeRecherche);
        tv = (TextView)rootView.findViewById(R.id.textView2);


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
/*  //ça marche pas le click fuck
        tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println(tv.getText().toString());
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {


                Toast.makeText(getActivity().getApplicationContext(),tv.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/
        return rootView;
    }
    private class JSONParse extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected String doInBackground(String... args) {
            TitreRecettes t = new TitreRecettes();
            // Getting JSON from URL
            String s = t.getJSONFromUrl("http://bouleau23.iut-infobio.priv.univ-lille1.fr:8080/v1/cook/recherche/"+recherchemot);
            return s;
        }
        @Override
        protected void onPostExecute(String json) {
          // Getting JSON Array
            try {
                String res[]=json.split("---");


                ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_recettes,R.id.textView2, res);
                lv.setAdapter(adapter);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}





