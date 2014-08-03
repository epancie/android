package course.examples.permissionexample.boomUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import apps101.Imagen.MainActivity;

public class BoomUserActivity extends Activity {

	private static final String TAG = BoomUserActivity.class.getSimpleName();
	private static final String ACTION_BOOM = "course.examples.permissionexample.boom.boom_action";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.boom_user_layout);

		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				try {
					startActivity(new Intent(ACTION_BOOM));
				} catch (Exception e) {
 					Log.e(TAG, "Intent Action:"+e.toString());
				}
			}
		});
	}
}
