package com.jetLee.customviewpractice.ui.property;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jetLee.customviewpractice.R;
import com.jetLee.customviewpractice.view.property.PropertyView;

/**
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

		ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view, "progress", 0, 70);
		objectAnimator.setDuration(800);
		objectAnimator.setStartDelay(500);
		objectAnimator.start();
//		view.setProgress(40);

	}
}
