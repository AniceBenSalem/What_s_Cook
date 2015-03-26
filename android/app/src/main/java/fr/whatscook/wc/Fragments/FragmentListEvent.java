package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import fr.whatscook.wc.R;
import fr.whatscook.wc.RequeteServeur;

public class FragmentListEvent extends Fragment {
        ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_event, container, false);
        lv = (ListView)rootView.findViewById(R.id.listEvent);
        new JSONParse().execute();
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
            String s = t.getJSONFromUrl("http://bouleau22.iut-infobio.priv.univ-lille1.fr:8080/v1/event/getEvenementA");
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