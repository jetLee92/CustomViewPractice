package com.jetLee.customviewpractice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jetLee.customviewpractice.Utils;

/**
 * @author：Jet啟思
 * @date:2018/7/26 11:05
 */
public class SportView extends View {

	private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final static float STROKE = Utils.dpToPx(16);
	private final static float PADDING = Utils.dpToPx(40);
	private RectF rectF = new RectF();
	private Rect textRect = new Rect();
	private Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

	public SportView(Context context) {
		super(context);
	}

	public SportView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(STROKE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		int radius = (int) (Math.min(getWidth(), getHeight()) / 2 - PADDING);

		// 画封闭的弧
		rectF.set(getWidth() / 2 - radius, getHeight() / 2 - radius,
				getWidth() / 2 + radius, getHeight() / 2 + radius);
		paint.setColor(Color.parseColor("#e0e0e0"));
		canvas.drawArc(rectF, 0, 360, false, paint);
		// 经过的弧
		paint.setColor(Color.parseColor("#2e7d32"));
		paint.setStrokeCap(Paint.Cap.ROUND);
		canvas.drawArc(rectF, -45, 200, false, paint);
		// 绘制圈中心文字
		String text = "abababa";
		textPaint.setColor(Color.parseColor("#000000"));
		textPaint.setTextSize(Utils.dpToPx(60));
		textPaint.setTextAlign(Paint.Align.CENTER);
		// 用FontMetrics的四个属性
//		Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
//		canvas.drawText(text, getWidth() / 2, getHeight() / 2 - (fontMetrics.ascent + fontMetrics.descent) / 2, textPaint);

		// 用getTextBounds
		textPaint.getTextBounds(text, 0, text.length(), textRect);
		canvas.drawText(text, getWidth() / 2, getHeight() / 2 - (textRect.top + textRect.bottom) / 2, textPaint);

	}
}
