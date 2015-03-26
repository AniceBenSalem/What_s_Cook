package fr.whatscook.wc.Fragments;

/**
 * Created by hilmoinb on 25/03/15.
 */

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

import fr.whatscook.wc.R;
import fr.whatscook.wc.RequeteServeur;

public class ResultatRecherche extends Fragment {
   public String nom = "";
    public TextView tv;
    public TextView tv2;
    public ResultatRecherche(){};
    public ResultatRecherche(String nom) {
        this.nom = nom;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.resultat_recherche, container, false);
        tv = (TextView)rootView.findViewById(R.id.larecette);
        tv2 = (TextView)rootView.findViewById(R.id.TitreRecette);
        tv2.setText(nom);
        new getTitre().execute();
        rootView.setFocusableInTouchMode(true);
         rootView.requestFocus();
       rootView.setOnKeyListener(new View.OnKeyListener() {


           @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if( keyCode == KeyEvent.KEYCODE_BACK ) {
                    FragmentManager fm = getFragmentManager();
                    if (fm != null) {
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.frame_container, new FragmentRecettes());
                        ft.commit();
                    }
                    return true;
                } else {
                    return false;
                }
            }



       });
        return rootView;
    }
    class getTitre extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... args) {
            String url = "http://bouleau22.iut-infobio.priv.univ-lille1.fr:8080/v1/cook/getRecettesName/"+nom;
            String result ="";
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet httpRequest = new HttpGet(url);
                HttpResponse response = httpClient.execute(httpRequest);
                HttpEntity entity = response.getEntity();
               String tmp = EntityUtils.toString(entity);
                result = new String(tmp.getBytes("ISO-8859-1"),"UTF-8");

            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }

            @Override
        protected void onPostExecute(String json) {
            // Getting JSON Array
            try {
                tv.setText(json);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}


