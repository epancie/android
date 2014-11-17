package org.homnet.panchonet.fragmentexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import org.homnet.panchonet.simplefragment.SimpleFragmentActivity;


public class FragmentExample extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);
    }

    public void simple(View v){
        Intent intent = new Intent(this, SimpleFragmentActivity.class);
        startActivity(intent);

    }

    public void Multiple(View v){
        Intent intent = new Intent(this, MultipleFragmentActivity.class);
        startActivity(intent);

}
