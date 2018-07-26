package com.jetLee.customviewpractice.view.property;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jetLee.customviewpractice.Utils;

/**
 * @author：Jet啟思
 * @date:2018/7/26 17:22
 */
public class TypeEvaluatorView extends View {

	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final static float STROKE = Utils.dpToPx(16);
	private final static float PADDING = Utils.dpToPx(40);
	private RectF rectF = new RectF();

	private int color = 0xffff0000;

	public TypeEvaluatorView(Context context) {
		super(context);
	}

	public TypeEvaluatorView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		int radius = (int) (Math.min(getWidth(), getHeight()) / 2 - PADDING);
		rectF.set(getWidth() / 2 - radius, getHeight() / 2 - radius,
				getWidth() / 2 + radius, getHeight() / 2 + radius);

		paint.setColor(color);
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
		invalidate();
	}
}
