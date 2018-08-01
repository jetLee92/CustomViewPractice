package com.jetLee.customviewpractice.ui.CanvasMatrixCamera;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jetLee.customviewpractice.R;
import com.jetLee.customviewpractice.view.CanvasMatrixCamera.ClipView;

/**
 * @author：Jet啟思
 * @date:2018/7/31 15:39
 */
public class ClipActivity extends AppCompatActivity {

	ClipView clipView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clip);

		clipView = findViewById(R.id.clip);

		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(clipView,"rightAngle",-15);
		objectAnimator.setDuration(2000);

		ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(clipView, "rotation", 270);
		objectAnimator2.setStartDelay(300);
		objectAnimator2.setDuration(2000);

		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playSequentially(objectAnimator2);
		animatorSet.setStartDelay(500);
		animatorSet.start();

	}
}
