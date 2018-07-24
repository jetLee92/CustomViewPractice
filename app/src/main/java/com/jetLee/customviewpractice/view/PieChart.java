package com.jetLee.customviewpractice.view;

import android.annotation.SuppressLint;
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
    RectF rectF;
    int OFFSET = Utils.dpToPx(20);

    public PieChart(Context context) {
        super(context);
    }

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = Math.min(getWidth(), getHeight()) / 2 - PADDING;
        // 饼图所在的矩形
        rectF = new RectF(getWidth() / 2 - radius, getHeight() / 2 - radius,
                getWidth() / 2 + radius, getHeight() / 2 + radius);
        int angle = 0;
        for (int i = 0; i < angles.length; i++) {
            paint.setColor(colors[i]);
            if (i == 0) {
                float offsetAngle = angle + angles[i] / 2;
                rectF.offset(OFFSET * (float) Math.cos(Math.toRadians(offsetAngle)), OFFSET * (float) Math.sin(Math.toRadians(offsetAngle)));
                canvas.drawArc(rectF, angle, angles[i], true, paint);
                rectF.offset(-OFFSET * (float) Math.cos(Math.toRadians(offsetAngle)), -OFFSET * (float) Math.sin(Math.toRadians(offsetAngle)));
            } else {
                canvas.drawArc(rectF, angle, angles[i], true, paint);
            }
            angle += angles[i];

        }
//        canvas.restore();
    }
}
