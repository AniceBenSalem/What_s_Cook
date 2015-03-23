package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.whatscook.wc.Acceuil;
import fr.whatscook.wc.R;

/**
 * Created by hilmoinb on 11/03/15.
 */
public class FragmentConnexion extends Fragment {


    public FragmentConnexion() {

    }


    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_connexion, container, false);
        final EditText login = (EditText) rootView.findViewById(R.id.email);
        final EditText pass = (EditText) rootView.findViewById(R.id.passwd);
        final Button loginButton = (Button) rootView.findViewById(R.id.connect);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText login = (EditText) rootView.findViewById(R.id.email);
                final EditText pass = (EditText) rootView.findViewById(R.id.passwd);
                final String loginTxt = login.getText().toString();
                final String passTxt = pass.getText().toString();
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(loginTxt);
                if (loginTxt.equals("") || !m.matches()) {
                    login.setError("error login");
                } else if (passTxt.equals("")) {
                    pass.setError("error password");
                } else {
                   
                    FragmentManager fm = getFragmentManager();
                    if (fm != null) {
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.frame_container, new FragmentAcceuil());
                        ft.commit();
                    }
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


}