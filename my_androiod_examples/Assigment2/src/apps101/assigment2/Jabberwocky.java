package apps101.assigment2;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class Jabberwocky extends Activity {

	WebView myWebView;
	MediaPlayer dontcallme;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		// Find that webView1
		myWebView = (WebView) findViewById(R.id.webView2);
		myWebView.getSettings().setBuiltInZoomControls(true);
		// Not needed today...
		// myWebView.getSettings().setJavaScriptEnabled(true);

		// Open asset/index.html
		myWebView.loadUrl("file:///android_asset/jabberwocky.html");
	}

	// When this Activity is ready (and the layout has been been created)
	// Android will call
	// our onResume method. The onResume method can be called again if we are
	// paused for some reason.
	@Override
	protected void onResume() {
		Log.e("Pickle", "onResume"); // Let's tell the World! Well anyone
										// reading the logcat
										// window...

		// "MediaPlayer.create(...)" is the code that actually creates a media
		// player object
		// "dontcallme =" is the code that changes ('assigns') our pointer to
		// point to the new media player object
		// You need to add "import android.media.MediaPlayer;" 
		// import statement at the top of this file

		dontcallme = MediaPlayer.create(this,R.raw.ashbory);
		// When 'create' returns the MediaPlayer is already in the prepared
		// state and ready to go!
		dontcallme.start();
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.e("Pickle", "onPause");
		// We're pausing. For this demo we will just stop the MediaPlayer and
		// then ask it to release
		// all of the valuable resources it's using.
		// If the user comes back to this app then onResume() will be called
		// again
		// (and we'll make a new Media player; see above)

		dontcallme.stop();
		dontcallme.release();
		super.onPause();
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabberwocky, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Check if the key event was the Back button and if there's history
		if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
			myWebView.goBack();
			return true;
		}
		// If it wasn't the Back key or there's no web page history, bubble up
		// to the default
		// system behavior (probably exit the activity)
		return super.onKeyDown(keyCode, event);
	}
	
	public void openWikipedia(View v) {
		String url = "http://es.wikipedia.org/wiki/Jabberwocky";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}
	
	public void openPicture(View v) {
		Intent i = new Intent();
		i.setClass(this, Picture.class);
		startActivity(i);
		finish();
	}
	
}
	

