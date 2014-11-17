package org.homnet.panchonet.multiplefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.
import android.widget.Button;

import org.homnet.panchonet.fragmentexample.R;

/**
 * Created by Pancho on 11/16/2014.
 */
public class MenuFragment extends Fragment{

    public MenuFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflater is LayoutInfalter, container is a ViewGroup
        View view = inflater.inflate(R.layout.menu_multi, container, false);

        Button btnJobs  = (Button) view.findViewById(R.id.btnJobs);
        Button btnTesis = (Button) view.findViewById(R.id.btnTesis);
        Button btnOther = (Button) view.findViewById(R.id.btnOther);

        btnJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnTesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}


