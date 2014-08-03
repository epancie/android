/*
Copyright (c) 2014 Lawrence Angrave
Dual licensed under Apache2.0 ((http://www.apache.org/licenses/LICENSE-2.0.txt) 
and MIT Open Source License (included below): 
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
THE SOFTWARE.
 */
package apps101.survey;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText mName;
	private EditText mPhone;
	private EditText mEmail;
	private EditText mComment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		// Look for these views after we've created them !

		mName = (EditText) findViewById(R.id.name);
		mPhone = (EditText) findViewById(R.id.phone);
		mEmail = (EditText) findViewById(R.id.email);
		mComment = (EditText) findViewById(R.id.comments);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void processForm(View duck) {
		Log.d("MainActivity", "processForm");

		String comments = mComment.getText().toString();
		String email = mEmail.getText().toString();
		String phone = mPhone.getText().toString();
		String name = mName.getText().toString();
		
//		Intent i = new Intent(Intent.ACTION_SEND);
//		i.setType("text/plain");
//		i.putExtra(Intent.EXTRA_TEXT, comments);
//		startActivity(i);
		
//		Intent i = new Intent(Intent.ACTION_VIEW);
//		i.setData(Uri.parse("sms:"+phone));//Alternative:	i.setData(Uri.fromParts("sms",phone,null));
//		i.putExtra("sms_body", comments);
//		startActivity(i);
		
		Intent i = new Intent(Intent.ACTION_SENDTO);
		Uri data = Uri.fromParts("mailto",email,null);
		i.setData(data);
		i.putExtra(Intent.EXTRA_SUBJECT, "Important email");
		i.putExtra(Intent.EXTRA_TEXT, name + "says: " + comments );
		startActivity(i);
		
	}
		
	
	public void processFormOld(View duck) {
		Log.d("MainActivity", "processForm");

		String comments = mComment.getText().toString();
		String email = mEmail.getText().toString();
		String phone = mPhone.getText().toString();
		String name = mName.getText().toString();

		int position = email.indexOf("@");
		if (position == -1) {
			Toast.makeText(this.getApplicationContext(),
					"Invalid email address!!!", Toast.LENGTH_LONG).show();
			mEmail.requestFocus();
			return;
		}

		// if (! email.contains("@")){
		//
		// }

		int comment_len = comments.length();
		if (comment_len == 0) {
			Toast.makeText(this.getApplicationContext(), "Give me comments!!!",
					Toast.LENGTH_LONG).show();
			mComment.requestFocus();
			return;
		}

		if (name.equals("pepe")) {
			Toast.makeText(this.getApplicationContext(), "Hello Pepe!!!",
					Toast.LENGTH_LONG).show();
			mComment.requestFocus();
		}
		
		int value = -1;
		boolean valueOK = false;
		try {
			value = Integer.parseInt(phone);
			valueOK = true;
			Log.d("processForm", "The phone number is:" + value);
		} catch (Exception e) {
			Log.d("processForm", "Invalid Phone Number - no digits" + phone);
		}

		//Animation to right
		Animation anim = AnimationUtils.makeOutAnimation(this, true);
		duck.startAnimation(anim);
		
		String usarname = email.substring(0, position);
		String thankyou = "Thankyou " + usarname + " !";

		Toast.makeText(this.getApplicationContext(), thankyou,
				Toast.LENGTH_LONG).show();

		//duck.setVisibility(View.INVISIBLE);
		//Toast.makeText(this.getApplicationContext(), R.string.app_name,
		//		Toast.LENGTH_LONG).show();
	}
}
