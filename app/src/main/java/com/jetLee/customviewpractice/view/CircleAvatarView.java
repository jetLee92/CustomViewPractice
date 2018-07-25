package com.jetLee.customviewpractice.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.jetLee.customviewpractice.R;
import com.jetLee.customviewpractice.Utils;

/**
 * @author：Jet啟思
 * @date:2018/7/25 15:55
 */
public class CircleAvatarView extends View {

	private int PADDING = Utils.dpToPx(40);
	private int offset = Utils.dpToPx(5);

	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

	private RectF rectF = new RectF();

	public CircleAvatarView(Context context) {
		super(context);
	}

	public CircleAvatarView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		int radius = Math.min(getWidth() / 2, getHeight() / 2) - PADDING;
		Bitmap bitmap = getBitmap(radius * 2);
		rectF.set(0, 0, getWidth(), getHeight());

		// 外部的圆，也就是那个圈
		paint.setColor(Color.parseColor("#FFFFFF"));
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);

		// 离屏缓冲
		int saved = canvas.saveLayer(rectF, paint);
		// 画切掉截取图片的圆
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius - offset, paint);
		Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
		paint.setXfermode(xfermode);
		canvas.drawBitmap(bitmap, getWidth() / 2 - bitmap.getWidth() / 2,
				getHeight() / 2 - bitmap.getHeight() / 2, paint);
		paint.setXfermode(null);

		// 去掉离屏缓冲
		canvas.restoreToCount(saved);
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

}
