package fr.whatscook.wc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Connexion extends ActionBarActivity{
    final String EXTRA_LOGIN = "user_login";
    final String EXTRA_PASSWORD = "user_password";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_compte);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final EditText login = (EditText) findViewById(R.id.email);
        final EditText pass = (EditText) findViewById(R.id.passwd);
        final Button loginButton = (Button) findViewById(R.id.connect);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText login = (EditText) findViewById(R.id.email);
                final EditText pass = (EditText) findViewById(R.id.passwd);
                final String loginTxt = login.getText().toString();
                final String passTxt = pass.getText().toString();
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(loginTxt);
                if (loginTxt.equals("") || !m.matches()) {
                    login.setError("error login");
                } else if (passTxt.equals("")) {
                    pass.setError("error password");
                } else {
                 /*   );*/
                    finish();
                }
                return;
            }
        });

    }

    public void register (View v){

        setContentView(R.layout.creer_compte);
        final EditText pseudo = (EditText) findViewById(R.id.pseudo);
        final Button registerButton = (Button) findViewById(R.id.enregistrer);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText pseudo = (EditText) findViewById(R.id.pseudo);
                final EditText mail= (EditText) findViewById(R.id.mail);
                final EditText passwd = (EditText) findViewById(R.id.passwd);
                final EditText passwd2 = (EditText) findViewById(R.id.passwd2);

                final String pseudoTxt = pseudo.getText().toString();
                final String mailTxt = mail.getText().toString();
                final String passwdtxt = passwd.getText().toString();
                final String passwd2txt = passwd2.getText().toString();

                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(mailTxt);
                if (pseudoTxt.equals("") ) {
                    pseudo.setError("error pseudo");
                } else if (mail.equals("") || !m.matches()) {
                    mail.setError("error email");
                }else if (passwdtxt.equals("") && passwd2txt.equals("")){
                    passwd.setError("merci de tout remplir");
                    passwd2.setError("merci de tout remplir");
                }else if (!passwdtxt.equals(passwd2txt)){
                    passwd2.setError("mdp differents");
                } else {
                    /* bdd*/
                    Bundle savedInstanceState = new Bundle();
                    savedInstanceState.putChar("test",'c');
                    new Acceuil().onCreate(savedInstanceState);
                  /*  Intent intent = new Intent(Connexion.this, Acceuil.class);
                    startActivity(intent);*/
                    finish();
                }
                return;

            }

        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()) {
            case R.id.homeAsUp:
                setContentView(R.layout.fragment_compte);
                return true;
             case R.id.useLogo:
             setContentView(R.layout.fragment_compte);
           return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
