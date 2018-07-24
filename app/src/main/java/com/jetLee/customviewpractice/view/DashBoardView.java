package com.jetLee.customviewpractice.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.jetLee.customviewpractice.Utils;

/**
 * @Author：Jet啟思
 * @Date:2018/7/24 15:02
 */
public class DashBoardView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint indicatorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static int PADDING = Utils.dpToPx(40);
    private static int ANGLE = 100;
    private static int STROKE_WIDTH = Utils.dpToPx(1);
    private static int SCALE_WIDTH = Utils.dpToPx(2);
    private static int SCALE_HEIGHT = Utils.dpToPx(10);
    private static int POINT_WIDTH = Utils.dpToPx(10);
    private static int INDICATOR_LENGTH = Utils.dpToPx(80);

    Path dash = new Path();
    Path indicatorPath = new Path();
    Path arcPath = new Path();
    PathEffect pathEffect;
    PathMeasure pathMeasure = new PathMeasure();

    public DashBoardView(Context context) {
        super(context);
    }

    public DashBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DashBoardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(STROKE_WIDTH);

        dash.addRect(0, 0, SCALE_WIDTH, SCALE_HEIGHT, Path.Direction.CCW);
    }

    @SuppressLint("DrawAllocation")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#212121"));

        // 表盘半径
        int radius = Math.min(getWidth(), getHeight()) / 2 - PADDING;
        // 画开口为120°的弧
        arcPath.addArc(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius, getHeight() / 2 + radius,
                90 + ANGLE / 2, 360 - ANGLE);
        paint.setColor(Color.parseColor("#E0E0E0"));
        canvas.drawPath(arcPath, paint);
//		canvas.drawArc(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius, getHeight() / 2 + radius,
//				90 + ANGLE / 2, 360 - ANGLE, false, paint);

        pathMeasure.setPath(arcPath, false);
        // 自定义虚线，是矩形组成的虚线
        pathEffect = new PathDashPathEffect(dash, (pathMeasure.getLength() - SCALE_WIDTH) / 20, 0, PathDashPathEffect.Style.ROTATE);

        // 画表盘刻度
        paint.setColor(Color.parseColor("#FFFFFF"));
        paint.setPathEffect(pathEffect);
        canvas.drawArc(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius, getHeight() / 2 + radius,
                90 + ANGLE / 2, 360 - ANGLE, false, paint);
        paint.setPathEffect(null);

        // 画指针中心
        paint.setColor(Color.parseColor("#E0E0E0"));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(POINT_WIDTH);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(getWidth() / 2, getHeight() / 2, paint);

        // 画指针
        indicatorPaint.setColor(Color.parseColor("#FF0000"));
        indicatorPaint.setStyle(Paint.Style.STROKE);
        indicatorPaint.setStrokeWidth(10);
//		double indicatorAngle = (360 - ANGLE) / 20 * 2 + 90 + ANGLE / 2;
        double indicatorAngle = 90 - ANGLE / 2;
        indicatorPath.moveTo(getWidth() / 2, getHeight() / 2);
        indicatorPath.rLineTo(((float) Math.sin(Math.toRadians(indicatorAngle))) * INDICATOR_LENGTH,
                ((float) Math.cos(Math.toRadians(indicatorAngle))) * INDICATOR_LENGTH);
        canvas.drawPath(indicatorPath, indicatorPaint);
    }
}
