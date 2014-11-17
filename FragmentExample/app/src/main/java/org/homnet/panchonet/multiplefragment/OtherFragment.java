package org.homnet.panchonet.multiplefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.homnet.panchonet.fragmentexample.R;

/**
 * Created by Pancho on 11/15/2014.
 */
public class OtherFragment extends Fragment {

    public OtherFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_multiple_other,container,false);

        Button mButtonMultiOther = (Button) rootView.findViewById(R.id.btnMultiFragment);

        mButtonMultiOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"You Click in Mutiple Fragment Other", Toast.LENGTH_LONG).show();

            }
        });



        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

   
        
   
}
