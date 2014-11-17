package org.homnet.panchonet.multiplefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.homnet.panchonet.fragmentexample.R;

/**
 * Created by Pancho on 11/15/2014.
 */
public class TesisFragment extends Fragment {

    public TesisFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_multiple_tesis, null);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

   
        
   
}
