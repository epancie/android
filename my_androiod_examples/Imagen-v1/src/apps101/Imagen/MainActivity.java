/*Copyright (c) 2014 Lawrence Angrave
Dual licensed under Apache2.0 and MIT Open Source License (included below): 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.*/

package apps101.Imagen;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private static final String KEY_SIZE = "key_size";
	private static final String USER = "user";
	private static final String KEY_CLICKED = "clicked";

	private static final String TAG = MainActivity.class.getSimpleName();

	private static final String KEY_COUNT = "count";
	private SharedPreferences mPrefs;
	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate!");
		mPrefs = getPreferences(MODE_PRIVATE);
		int count = mPrefs.getInt(KEY_COUNT, 0);
		int text_size = mPrefs.getInt(KEY_SIZE, 0);
		mPrefs.
				
		count = count + 1;
		text_size  = text_size + 10;
		
		Editor editor = mPrefs.edit();
		editor.putInt(KEY_COUNT, count);
		editor.putInt(KEY_SIZE, text_size);
		editor.commit();

		mTextView = new TextView(this);
		mTextView.setTextSize(text_size);
		mTextView.setText("Count : " + count);
		Log.d(TAG, "Count is " + count);
		setContentView(mTextView);
		// setContentView(R.layout.activity_main);

		mTextView.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		//Todo: Can you refactor these keys into a constants?
		
		int clickCount = 20 + mPrefs.getInt(KEY_CLICKED, 0);
		mPrefs.edit().putInt(KEY_CLICKED, clickCount).putBoolean(USER, true).commit();
		
		//mPrefs.edit().putInt("clicked", clickCount);
		//mPrefs.edit().putBoolean("user", true);
		//mPrefs.edit().commit();
		// The hexadecimal value 0xff00ff00 is
		// opaque green. Why?
		if(clickCount >200){mTextView.setTextColor(0xffff0000);}
		else{mTextView.setTextColor(0xff00ff00);}
		mTextView.setText("Click!" + clickCount);
	}
}
