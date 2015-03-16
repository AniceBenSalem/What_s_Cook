package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
 * Created by Benjamin on 14/03/2015.
 */
public class FragmentCompte extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.creer_compte, container, false);
       final Button registerButton = (Button) rootView.findViewById(R.id.enregistrer);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText pseudo = (EditText) rootView.findViewById(R.id.pseudo);
                final EditText mail = (EditText) rootView.findViewById(R.id.mail);
                final EditText passwd = (EditText) rootView.findViewById(R.id.passwd);
                final EditText passwd2 = (EditText) rootView.findViewById(R.id.passwd2);

                final String pseudoTxt = pseudo.getText().toString();
                final String mailTxt = mail.getText().toString();
                final String passwdtxt = passwd.getText().toString();
                final String passwd2txt = passwd2.getText().toString();

                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(mailTxt);
                if (pseudoTxt.equals("")) {
                    pseudo.setError("error pseudo");
                } else if (mail.equals("") || !m.matches()) {
                    mail.setError("error email");
                } else if (passwdtxt.equals("") && passwd2txt.equals("")) {
                    passwd.setError("merci de tout remplir");
                    passwd2.setError("merci de tout remplir");
                } else if (!passwdtxt.equals(passwd2txt)) {
                    passwd2.setError("mdp differents");
                } else {
                    FragmentManager fm = getFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.frame_container, new FragmentAcceuil());
                    ft.commit();
                    }
            }
        });
        return rootView;
    }
}