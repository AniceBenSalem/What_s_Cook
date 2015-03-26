package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.whatscook.wc.Acceuil;
import fr.whatscook.wc.R;
import fr.whatscook.wc.RequeteServeur;

/**
 * Created by hilmoinb on 11/03/15.
 */
public class FragmentConnexion extends Fragment {
       public String name ="";
       public String passwd="";
       EditText login;

    public FragmentConnexion() {

    }


    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_connexion, container, false);

       login = (EditText) rootView.findViewById(R.id.email);
        final EditText pass = (EditText) rootView.findViewById(R.id.passwd);
        final Button loginButton = (Button) rootView.findViewById(R.id.connect);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText login = (EditText) rootView.findViewById(R.id.email);
                final EditText pass = (EditText) rootView.findViewById(R.id.passwd);
                final String loginTxt = login.getText().toString();
                final String passTxt = pass.getText().toString();

                if (loginTxt.equals("")) {
                    login.setError("error login");
                } else if (passTxt.equals("")) {
                    pass.setError("error password");
                } else {

                        name = loginTxt.toString();
                        passwd = passTxt.toString();
                        new JSONAndro().execute();


                }
                return;
            }
        });
        final Button registerButton = (Button) rootView.findViewById(R.id.create_account);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();

                if (fm != null) {
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frame_container, new FragmentCompte());
                    ft.commit();
                }


            }

        });


        return rootView;
    }
    private class JSONAndro extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        @Override
        protected String doInBackground(String... args) {
            RequeteServeur t = new RequeteServeur();
            // Getting JSON from URL
            String s = t.getJSONFromUrl("http://bouleau22.iut-infobio.priv.univ-lille1.fr:8080/v1/connexion/android/"+name+"/"+passwd);
            return s;
        }
        @Override
        protected void onPostExecute(String json) {
            if (json.equals("yes")){
               Acceuil.editor.putString("login", name);
               Acceuil.editor.putString("passwd", passwd);
              FragmentManager fm = getFragmentManager();
               if (fm != null) {
                  FragmentTransaction ft = fm.beginTransaction();
                  ft.replace(R.id.frame_container, new FragmentAcceuil());
                     ft.commit();

            } else {
                   login.setError("mauvais mot de passe ou identifiant");
               }
        }
    }
}







}
