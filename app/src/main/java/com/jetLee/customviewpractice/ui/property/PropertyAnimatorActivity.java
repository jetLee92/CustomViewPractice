package com.jetLee.customviewpractice.ui.property;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jetLee.customviewpractice.R;
import com.jetLee.customviewpractice.view.property.PropertyView;

/**
 * ObjectAnimator使用
 *
 * @author：Jet啟思
 * @date:2018/7/26 14:49
 */
public class PropertyAnimatorActivity extends AppCompatActivity {

	PropertyView view;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_animator);

		view = findViewById(R.id.propertyView);

//		view.animate()
////				.translationY(Utils.dpToPx(200))
//				.scaleX(0.5f)
//				.setStartDelay(800);

//		ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view, "progress", 0, 70);
//		objectAnimator.setDuration(800);
//		objectAnimator.setStartDelay(500);
//		objectAnimator.start();

		Keyframe keyframe1 = Keyframe.ofInt(0, 0);
		Keyframe keyframe2 = Keyframe.ofInt(0.5f, 80);
		Keyframe keyframe3 = Keyframe.ofInt(1, 60);
		PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("progress", keyframe1, keyframe2, keyframe3);
		ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolder);
		objectAnimator.setDuration(1200);
		objectAnimator.setStartDelay(800);
		objectAnimator.start();

	}
}
