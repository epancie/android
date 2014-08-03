package com.pancho.movingball;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

public class myBall extends View {

	private static final String TAG = MainActivity.class.getSimpleName();
	private Bitmap ball;
	private int Y;

	public myBall(MainActivity context) {
		super(context);
		//ball = BitmapFactory.decodeResource(getResources(),	R.drawable.soccerball);
		ball = BitmapFactory.decodeResource(getResources(),	R.drawable.soccerball);
		Y = 0;
		int bH = ball.getHeight();
		int bW = ball.getWidth();
		Log.d(TAG,"Ball size = " + bH +"x"+bW);
				
		
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(0xffffffff);
		canvas.drawBitmap(ball, (canvas.getWidth() / 2), Y, null);
		if (Y < canvas.getHeight()) {
			Y = Y + 10;
		} else {
			Y = 0;
		}
		invalidate();
	}
}