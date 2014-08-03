package com.pancho.imagen_v3_1;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	private Bitmap mBitmap;
	private Canvas mCanvas;
	private ImageView mImageView;
	private Paint mPaint;
	private Bitmap mRain;

	// private BitmapFactory mRain;
	// private Resources mResursces;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "on Create!");
		mBitmap = Bitmap.createBitmap(480, 600, Bitmap.Config.ARGB_8888);

		// mRain = new BitmapFactory();
		// mResursces = getResources();
		// mRain.decodeResource(getResources(), R.drawable.rain_penguin);
		// mRain = BitmapFactory.decodeResource(getResources(),
		// R.drawable.rain_penguin);

		mCanvas = new Canvas(mBitmap);
		mCanvas.drawColor(0xff5500);

		mPaint = new Paint();
		mPaint.setColor(0xff0000ff);
		mPaint.setStrokeWidth(10);

		mCanvas.drawLine(0, 0, 480, 600, mPaint);
		// mCanvas.drawBitmap(mRain , 100, 100, null);

		mImageView = new ImageView(this);
		mImageView.setImageBitmap(mBitmap);
		setContentView(mImageView);

		for (int i = 0; i < 480;) {
			int j;
			j = i * 480 / 600;
			mCanvas.drawCircle(i, j, 10, mPaint);
			mImageView.setImageBitmap(mBitmap);
			setContentView(mImageView);
			i = i + 10;

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
