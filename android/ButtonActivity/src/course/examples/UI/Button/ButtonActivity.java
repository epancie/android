package course.examples.UI.Button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ButtonActivity extends Activity {
	int count = 0;
	int multi = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Button button1 = (Button) findViewById(R.id.button1);
		final Button button2 = (Button) findViewById(R.id.button2);

		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				button1.setText("Got Pressed:" + ++count);
			}
		});
		
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				multi = multi * 2;
				button2.setText("Got Pressed:" + multi);
			}
		});

	}
}