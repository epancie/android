package org.homnet.panchonet.multiplefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.homnet.panchonet.fragmentexample.R;

import static org.homnet.panchonet.fragmentexample.R.layout.fragment_multiple_jobs;

/**
 * Created by Pancho on 11/15/2014.
 */
public class JobsFragment extends Fragment {

    public JobsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_multiple_jobs,container,false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

   
        
   
}
