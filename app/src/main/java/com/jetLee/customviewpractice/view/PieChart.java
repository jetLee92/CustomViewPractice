package com.jetLee.customviewpractice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jetLee.customviewpractice.Utils;

/**
 * Description：
 * Author：Jet啟思
 * Time：2018/7/25 1:32
 */
public class PieChart extends View {

	Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

	private static int PADDING = Utils.dpToPx(80);
	int[] colors = {Color.parseColor("#512DA8"), Color.parseColor("#2E7D32"),
			Color.parseColor("#BF360C"), Color.parseColor("#f44336")};
	int[] angles = {60, 110, 90, 100};
	RectF rectF = new RectF();
	int offset = Utils.dpToPx(20);

	public PieChart(Context context) {
		super(context);
	}

	public PieChart(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		int radius = Math.min(getWidth(), getHeight()) / 2 - PADDING;
		// 饼图所在的矩形
		rectF.set(getWidth() / 2 - radius, getHeight() / 2 - radius,
				getWidth() / 2 + radius, getHeight() / 2 + radius);
		int angle = 0;
		for (int i = 0; i < angles.length; i++) {
			paint.setColor(colors[i]);
			if (i == 0) {
				// 已占用的角度+扇形角度/2
				float offsetAngle = angle + angles[i] / 2;
				// 偏移（对应偏移的cos和sin）
				rectF.offset(offset * (float) Math.cos(Math.toRadians(offsetAngle)), offset * (float) Math.sin(Math.toRadians(offsetAngle)));
				canvas.drawArc(rectF, angle, angles[i], true, paint);
				// 恢复偏移
				rectF.offset(-offset * (float) Math.cos(Math.toRadians(offsetAngle)), -offset * (float) Math.sin(Math.toRadians(offsetAngle)));
			} else {
				canvas.drawArc(rectF, angle, angles[i], true, paint);
			}
			// 已经使用过的角度
			angle += angles[i];
		}
	}
}
