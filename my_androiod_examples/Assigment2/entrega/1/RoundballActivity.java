package com.android101.appwebpagesviewer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class RoundballActivity extends Activity {

	private WebView myWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_roundball);
		myWebView = (WebView) findViewById(R.id.webViewRoundball);
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setDomStorageEnabled(true);
		myWebView.loadUrl("file:///android_asset/webcontent/roundball/roundball.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.roundball, menu);
		return true;
	}

}
