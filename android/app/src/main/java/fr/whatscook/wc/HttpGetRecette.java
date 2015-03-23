package fr.whatscook.wc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.widget.TextView;
//
public class HttpGetRecette extends AsyncTask<TextView, Void, String> {
    TextView t;
    String result = "fail";

    @Override
    protected String doInBackground(TextView... params) {
        // TODO Auto-generated method stub
        this.t = params[0];
        return GetSomething();
    }

    final String GetSomething()
    {
        String url = "http://bouleau04.iut-infobio.priv.univ-lille1.fr:8080/v1/cook/RecetteDuJour";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpRequest = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpRequest);
            HttpEntity entity = response.getEntity();
            String res = EntityUtils.toString(entity);
            JSONObject json = new JSONObject(res);
             result = new String(json.getString("TxtRecette").getBytes("ISO-8859-1"),"UTF-8");


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }


    protected void onPostExecute(String page)
    {
        t.setText(page);
    }

}