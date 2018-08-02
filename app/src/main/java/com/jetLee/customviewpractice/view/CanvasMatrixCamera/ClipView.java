package com.jetLee.customviewpractice.view.CanvasMatrixCamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
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
    private int imageSize = Utils.dpToPx(220);
    private int offset = Utils.dpToPx(100);
    private int PADDING = Utils.dpToPx(50);
    private int corner = Utils.dpToPx(20);
    private RectF rectF = new RectF();
    private RectF rectP = new RectF();
    private Camera camera;

    private float angle = 15;
    private float rightAngle;
    private float leftAngle;
    private float rotation;

    public ClipView(Context context) {
        super(context);
    }

    public ClipView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        bitmap = Utils.getBitmap(getResources(), imageSize);
        camera = new Camera();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        camera.save();
        camera.rotateY(leftAngle * angle);

        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.rotate(-rotation);
        camera.applyToCanvas(canvas);
        canvas.clipRect(0, -imageSize, -imageSize, imageSize);
        canvas.rotate(rotation);
        canvas.translate(-getWidth() / 2, -getHeight() / 2);

        canvas.drawBitmap(bitmap, (getWidth() - imageSize) / 2, (getHeight() - imageSize) / 2, paint);

        camera.restore();
        canvas.restore();

//        canvas.save();
//        camera.save();
//        camera.rotateY(-rightAngle * angle);
//
//        canvas.translate(getWidth() / 2, getHeight() / 2);
//        canvas.rotate(-rotation);
//        camera.applyToCanvas(canvas);
//        canvas.clipRect(0, -imageSize, imageSize, imageSize);
//        canvas.rotate(rotation);
//        canvas.translate(-getWidth() / 2, -getHeight() / 2);
//        canvas.drawBitmap(bitmap, (getWidth() - imageSize) / 2, (getHeight() - imageSize) / 2, paint);
//
//        camera.restore();
//        canvas.restore();

    }

    public float getRightAngle() {
        return rightAngle;
    }

    public void setRightAngle(float rightAngle) {
        this.rightAngle = rightAngle;
        invalidate();
    }

    @Override
    public float getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(float rotation) {
        this.rotation = rotation;
        invalidate();
    }

    public float getLeftAngle() {
        return leftAngle;
    }

    public void setLeftAngle(float leftAngle) {
        this.leftAngle = leftAngle;
        invalidate();
    }
}
