package com.jetLee.customviewpractice.view.measurelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jetLee.customviewpractice.Utils;

/**
 * @author：Jet啟思
 * @date:2018/8/6 15:38
 */
public class CircleView extends View {

    private int PADDING = Utils.dpToPx(30);
    private int RADIUS = Utils.dpToPx(60);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = PADDING + RADIUS * 2;
        int height = PADDING + RADIUS * 2;
        setMeasuredDimension(resolveSize(width, widthMeasureSpec), resolveSize(height, heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#F22A5B"));
        canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint);

    }

}
