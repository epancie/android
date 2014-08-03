package com.android101.appwebpagesviewer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class JabberwockyActivity extends Activity {

	private WebView myWebView;
	private MediaPlayer jabberMP;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		myWebView = (WebView) findViewById(R.id.webViewJabberwocky);
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView.loadUrl("file:///android_asset/webcontent/jabberwocky.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		jabberMP = MediaPlayer.create(this, R.raw.nobodys_perfect);
		jabberMP.setLooping(true);
		jabberMP.start();
		super.onResume();
	}

	@Override
	protected void onPause() {
		jabberMP.stop();
		jabberMP.release();
		super.onPause();
	}
	
	public void openWiki(View v) {
		String url = "http://en.wikipedia.org/wiki/Jabberwocky";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}
	
	public void openImage(View v) {
		myWebView.loadUrl("file:///android_asset/330px-Aliceroom2.jpg");
	}
	
	// The onKeyDown code is from
	// http://developer.android.com/guide/webapps/webview.html
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
}
