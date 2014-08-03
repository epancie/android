package app.panchonet.cvplay;

import org.apache.http.HttpHost;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	
	WebView myWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//set a proxy
		//DefaultHttpClient httpClient = new DefaultHttpClient();
		//HttpHost proxy = new HttpHost("200.49.149.228", 3128); //proxy that i need 
		//httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
		 
		String ua = "Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.63 Safari/537.31";
		// Find that webView1
		myWebView = (WebView) findViewById(R.id.webView1);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setDomStorageEnabled(true);
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView.getSettings().setUserAgentString(ua);
		myWebView.getSettings().setUseWideViewPort(true);
		myWebView.getSettings().setLoadWithOverviewMode(true);
		myWebView.loadUrl("http://www.cablevisionplay.com.ar/ar/");
		
		myWebView.setWebViewClient(new WebViewClient() {
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            view.loadUrl(url);
	            return false;
	        }
	    });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    // Check if the key event was the Back button and if there's history
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
	        myWebView.goBack();
	        return true;
	    }
	    // If it wasn't the Back key or there's no web page history, bubble up to the default
	    // system behavior (probably exit the activity)
	    return super.onKeyDown(keyCode, event);
	}
	

}