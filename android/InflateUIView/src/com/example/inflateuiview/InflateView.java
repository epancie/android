package com.example.inflateuiview;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
 
public class InflateView extends Activity {
     
    LinearLayout lLayout;
    float[] orientation;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final LayoutInflater  inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Button b = (Button)inflater.inflate(R.layout.buttons, null);
         
        lLayout = (LinearLayout)findViewById(R.id.layout1);
        lLayout.addView(b);
         
        b.setOnClickListener(new OnClickListener() {
             
            public void onClick(View v) {
                //restrict to adding only 1 textview child element
                if (lLayout.getChildAt(2) == null)
                {
                TextView tv = (TextView)inflater.inflate(R.layout.text, null);
                lLayout.addView(tv);
                }
            }
        });
    }
}
