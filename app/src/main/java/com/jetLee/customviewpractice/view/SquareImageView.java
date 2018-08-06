package com.jetLee.customviewpractice.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.util.Measure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.jetLee.customviewpractice.R;
import com.jetLee.customviewpractice.Utils;

/**
 * @author：Jet啟思
 * @date:2018/8/6 14:34
 */
public class SquareImageView extends android.support.v7.widget.AppCompatImageView {

    private int PADDING = Utils.dpToPx(30);
    private int RADIUS = Utils.dpToPx(60);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = MeasureSpec.getSize(widthMeasureSpec);
//        int height = MeasureSpec.getSize(heightMeasureSpec);
////        setMeasuredDimension(resolveSize(Utils.dpToPx(200), widthMeasureSpec), resolveSize(Utils.dpToPx(100), heightMeasureSpec));
//
//        int size = Math.min(width, height);
//        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#F22A5B"));

        canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint);

    }

    //    @Override
//    public void layout(int l, int t, int r, int b) {
//        super.layout(l, t, Utils.dpToPx(200), Utils.dpToPx(200));
//    }
}
