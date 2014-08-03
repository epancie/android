package apps101.assigment2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class Picture extends Activity {

	WebView myWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Find that webView1
		myWebView = (WebView) findViewById(R.id.webView1);
		myWebView.getSettings().setBuiltInZoomControls(true);
		// Not needed today...
		// myWebView.getSettings().setJavaScriptEnabled(true);

		// Open asset/index.html
		myWebView.loadUrl("file:///android_asset/images.jpg");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.picture, menu);
		return true;
	}

}
