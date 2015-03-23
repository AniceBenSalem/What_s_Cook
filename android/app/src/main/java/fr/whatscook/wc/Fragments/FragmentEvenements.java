package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.whatscook.wc.R;

/**
 * Created by hilmoinb on 11/03/15.
 */
public class FragmentEvenements extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_evenements, container, false);
        Button b = (Button) rootView.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {



                                  /*   try {
                                         URL url = new URL("http://bouleau25.iut-infobio.priv.univ-lille1.fr:8080/v1/cook/nbRecettes");

                                         HttpURLConnection urlConnection = (HttpURLConnection) url
                                                 .openConnection();

                                         InputStream in = urlConnection.getInputStream();

                                         InputStreamReader isw = new InputStreamReader(in);
                                         System.out.println("connection ok");

                                         int data = isw.read();
                                         while (data != -1) {
                                             char current = (char) data;
                                             data = isw.read();
                                             System.out.print(current);
                                         }
                               HttpClient client = new DefaultHttpClient();

                                     HttpGet request = new HttpGet();
                                     HttpResponse response;
                                     TextView v1 = (TextView) rootView.findViewById(R.id.textView3);
                                     try {
                                         URI address=new URI("http://172.18.48.191:8080/v1/cook/nbRecettes");
                                         request.setURI(address);
                                         v1.setText("URI build \n");
                                         System.out.println("reception 3");

                                     } catch (Exception e) {
                                         v1.setText("URI not build \n");
                                     }
                                    try{
                                         response = client.execute(request);

                                     //    HttpEntity entity = response.getEntity();

                                       //  String json = entity.getContent().toString();
                                        v1.setText("ok\n");
                                     }catch(Exception e){
                                        v1.setText("error\n");
                                     }

                                 }
                             }*/

          /*     String reponse = null ;


                    HttpGet requete = new HttpGet("http://172.18.48.191:8080/v1/cook/nbRecettes");
                    AndroidHttpClient client = AndroidHttpClient.newInstance(Build.MODEL);
                    try {
                        reponse = client.execute(requete, new BasicResponseHandler());
                        TextView v1 = (TextView) rootView.findViewById(R.id.textView3);
                        System.out.println(reponse);
                        v1.setText(reponse);
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (client != null) client.close();
                    }
                }

            }*/

                                 }
                             }
            );


            return rootView;
        }
    }

