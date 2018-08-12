package com.jetLee.customviewpractice.view.touch;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Description：
 * Author：Jet啟思
 * Time：2018/8/12 12:21
 */
public class TouchView extends ViewGroup {
    public TouchView(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }
}
