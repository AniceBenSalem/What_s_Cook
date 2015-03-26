package fr.whatscook.wc.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import fr.whatscook.wc.R;

/**
 * Created by hilmoinb on 11/03/15.
 */
public class FragmentEvenements extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_evenements, container, false);
       final TextView newEvent = (TextView)rootView.findViewById(R.id.newEvent);
        TextView setEvent = (TextView)rootView.findViewById(R.id.setEvent);
        TextView listEvent = (TextView)rootView.findViewById(R.id.listEvent);

        newEvent.setText("jirfoif");
        newEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(newEvent.getText()+"prout");
            }
        });
        newEvent.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                System.out.println(v.getText());

                return true;

            }
        });

  /*      ScrollView scroll = (ScrollView) rootView.findViewById(R.id.scrollEvent);

        TextView[] tv = new TextView[4];
        for (int i = 0; i < 4; i++) {
            tv[i]= new TextView(getActivity());
            tv[i].setText("lolll\nlolloll^loll");
       //     scroll.a;

        }
            //   }

        */
            return rootView;
        }

}

