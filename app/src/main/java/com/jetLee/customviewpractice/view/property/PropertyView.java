package com.jetLee.customviewpractice.view.property;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jetLee.customviewpractice.R;
import com.jetLee.customviewpractice.Utils;

/**
 * @author：Jet啟思
 * @date:2018/7/26 14:57
 */
public class PropertyView extends View {

	private static int IMAGE_SIZE = Utils.dpToPx(120);
//	private static int PADDING = Utils.dpToPx(30);
//	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

	private Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final static float STROKE = Utils.dpToPx(16);
	private final static float PADDING = Utils.dpToPx(40);
	private RectF rectF = new RectF();

	private int progress;

	public PropertyView(Context context) {
		super(context);
	}

	public PropertyView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

//		canvas.drawBitmap(getBitmap(IMAGE_SIZE), PADDING, PADDING * 2, paint);

		int radius = (int) (Math.min(getWidth(), getHeight()) / 2 - PADDING);
		rectF.set(getWidth() / 2 - radius, getHeight() / 2 - radius,
				getWidth() / 2 + radius, getHeight() / 2 + radius);


		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(STROKE);
		paint.setColor(Color.parseColor("#2e7d32"));
		paint.setStrokeCap(Paint.Cap.ROUND);
		canvas.drawArc(rectF, -230, 360 * progress / 100, false, paint);

		textPaint.setColor(Color.parseColor("#000000"));
		textPaint.setTextSize(Utils.dpToPx(80));
		textPaint.setFakeBoldText(true);
		textPaint.setTextAlign(Paint.Align.CENTER);
		Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
		canvas.drawText(progress + "%", getWidth() / 2, getHeight() / 2 - (fontMetrics.ascent + fontMetrics.descent) / 2, textPaint);

	}

	/**
	 * 调整图片大小
	 *
	 * @param size
	 * @return
	 */
	private Bitmap getBitmap(int size) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(getResources(), R.mipmap.girl, options);
		options.inJustDecodeBounds = false;
		options.inDensity = Math.min(options.outWidth, options.outHeight);
		options.inTargetDensity = size;
		return BitmapFactory.decodeResource(getResources(), R.mipmap.girl, options);
	}

	public float getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
		invalidate();
	}
}
