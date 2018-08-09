package com.jetLee.customviewpractice.view.measurelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

/**
 * @author：Jet啟思
 * @date:2018/8/6 14:29
 */
public class FlowTagLayout extends ViewGroup {

    private Rect[] childrenBounds;

    public FlowTagLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 已用宽度
        int widthUsed = 0;
        // 已用高度
        int heightUsed = 0;
        // 当前行高度
        int lineHeight = 0;
        // 本身的宽度
        int parentWidth = 0;
        // 本身的高度
        int parentHeight = 0;

        int specWidth = MeasureSpec.getSize(widthMeasureSpec);
        int specWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int specHeight = MeasureSpec.getSize(heightMeasureSpec);
        int specHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        int childCount = getChildCount();
        if (childrenBounds == null) {
            childrenBounds = new Rect[childCount];
        } else if (childrenBounds.length < childCount) {
            childrenBounds = Arrays.copyOf(childrenBounds, childCount);
        }

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            measureChildWithMargins(child, widthMeasureSpec, widthUsed, heightMeasureSpec, heightUsed);

            // 判断是否换行（1.不是非限制  2.已用宽度+当前添加的child宽度+左右的padding 是否大于 父view自身测量的宽度）
            if (specWidthMode != MeasureSpec.UNSPECIFIED &&
                    widthUsed + child.getMeasuredWidth() + getPaddingLeft() + getPaddingRight() > specWidth) {
                // 把已用宽度置0,
                widthUsed = 0;
                parentWidth = specWidth;
                // 已用高度 = 之前已用高度 + 当前行的高度
                heightUsed = heightUsed + lineHeight;
                lineHeight = 0;
                measureChildWithMargins(child, widthMeasureSpec, widthUsed, heightMeasureSpec, heightUsed);
            }

            Rect childBounds = childrenBounds[i];
            if (childBounds == null) {
                childBounds = childrenBounds[i] = new Rect();
            }
            // 保存child的位置
            childBounds.set(widthUsed, heightUsed, widthUsed + child.getMeasuredWidth(), heightUsed + child.getMeasuredHeight());
            // 当前行已用的宽度
            widthUsed = widthUsed + child.getMeasuredWidth();
            // viewGroup的宽度,始终把最大的宽度给到parentWidth
            parentWidth = Math.max(parentWidth, widthUsed);
            // 把child中最大的高度给到lineHeight，记录当前行的高度
            lineHeight = Math.max(lineHeight, child.getMeasuredHeight());
        }
        // viewGroup的高度 = 已用的高度 + 当前行高度
        parentHeight = heightUsed + lineHeight;

        setMeasuredDimension(resolveSizeAndState(parentWidth, widthMeasureSpec, 0),
                resolveSizeAndState(parentHeight, heightMeasureSpec, 0));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            Rect childRect = childrenBounds[i];
            view.layout(childRect.left, childRect.top, childRect.right, childRect.bottom);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
