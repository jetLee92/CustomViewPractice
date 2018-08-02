package com.jetLee.customviewpractice.ui.CanvasMatrixCamera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.jetLee.customviewpractice.R;
import com.jetLee.customviewpractice.view.CanvasMatrixCamera.ClipView;

/**
 * @author：Jet啟思
 * @date:2018/7/31 15:39
 */
public class ClipActivity extends AppCompatActivity {

    ClipView clipView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip);

        clipView = findViewById(R.id.clip);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(clipView, "rightAngle", 1);
        objectAnimator.setDuration(500);

        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(clipView, "rotation", 270);
        objectAnimator2.setStartDelay(300);
        objectAnimator2.setDuration(800);

        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(clipView, "leftAngle", 1);
        objectAnimator3.setDuration(500);

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(objectAnimator2, objectAnimator3);
        animatorSet.setStartDelay(500);
        animatorSet.start();
//        animatorSet.addListener(new AnimatorListenerAdapter() {
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//                super.onAnimationRepeat(animation);
//            }
//        });

    }
}
