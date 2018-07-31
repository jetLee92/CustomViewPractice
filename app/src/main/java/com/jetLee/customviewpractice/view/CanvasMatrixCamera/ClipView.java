package com.jetLee.customviewpractice.view.CanvasMatrixCamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jetLee.customviewpractice.Utils;

/**
 * @author：Jet啟思
 * @date:2018/7/31 15:41
 */
public class ClipView extends View {

	Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private Bitmap bitmap;
	private int imageSize = Utils.dpToPx(200);
	private int offset = Utils.dpToPx(100);
	private int PADDING = Utils.dpToPx(20);
	private int corner = Utils.dpToPx(20);
	private RectF rectF = new RectF();
	private RectF rectP = new RectF();
	private Camera camera;

	public ClipView(Context context) {
		super(context);
	}

	public ClipView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
//		this.setLayerType(View.LAYER_TYPE_NONE, paint);
		init();
	}

	private void init() {
		bitmap = Utils.getBitmap(getResources(), imageSize);
		camera = new Camera();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
//		canvas.rotate(30);
//		canvas.translate(offset, 0);
//		canvas.translate(-offset, 0);

//		Matrix matrix = new Matrix();
//		matrix.reset();
//		matrix.postRotate(30);
//		matrix.postTranslate(0, offset);
//		matrix.setTranslate(offset,0); // set会清空matrix的所有变换
//		matrix.preTranslate(offset,0); // 矩阵前乘
//		canvas.concat(matrix);

		canvas.save();
		camera.save();
//		camera.translate(offset, 0, 0);
//		camera.rotateX(-30);
//		canvas.translate(imageSize / 2 + PADDING, imageSize / 2 + PADDING);
		camera.applyToCanvas(canvas);
//		canvas.translate(-(imageSize / 2 + PADDING), -(imageSize / 2 + PADDING));
		camera.restore();

		rectF.set(0, 0, getWidth(), getHeight());
		int saved = canvas.saveLayer(rectF, paint);

//		 画圆角图片
		rectP.set(PADDING, PADDING, imageSize + PADDING, imageSize + PADDING);
		canvas.drawRoundRect(rectP, corner, corner, paint);

		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		canvas.drawBitmap(bitmap, PADDING, PADDING, paint);
		paint.setXfermode(null);

		canvas.restoreToCount(saved);
		canvas.restore();
	}
}
