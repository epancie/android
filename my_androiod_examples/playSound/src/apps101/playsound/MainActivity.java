package apps101.playsound;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.content.Intent; 
import android.net.Uri; 
import android.view.View;

public class MainActivity extends Activity {

	MediaPlayer playmusic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("debug","onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		playmusic = MediaPlayer.create(this, R.raw.byu );
	}

	 @Override
	protected void onResume() {
		Log.d("debug","onResume");
		playmusic.start();
		super.onResume();
	}
	
	 @Override
	protected void onPause() {
		 Log.d("debug","onPause");
		 playmusic.stop();
		 super.onPause();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void openCoursera(View v) { 
		// Once you have this working, change the string to another web page 
		    String url = "http://www.coursera.org"; 
		    Intent i = new Intent(Intent.ACTION_VIEW); 
		    i.setData(Uri.parse(url)); 
		    startActivity(i); 
	}

}
