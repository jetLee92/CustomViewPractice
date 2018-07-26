package com.jetLee.customviewpractice.ui.property;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jetLee.customviewpractice.R;
import com.jetLee.customviewpractice.view.property.TypeEvaluatorView;

/**
 * 估值器使用
 *
 * @author：Jet啟思
 * @date:2018/7/26 17:20
 */
public class TypeEvaluatorActivity extends AppCompatActivity {

	private TypeEvaluatorView view;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_type_evaluator);

		view = findViewById(R.id.typeEvaluatorView);

//		ObjectAnimator objectAnimator = ObjectAnimator.ofObject(view,"color", new ArgbEvaluator(), 0xff00ff00);
//		ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view, "color", 0xff00ff00);
//		objectAnimator.setEvaluator(new ArgbEvaluator());
//		objectAnimator.setDuration(2000);
//		objectAnimator.setStartDelay(500);
//		objectAnimator.start();

		view.animate()
				.scaleX(0.5f)
				.scaleY(0.5f)
				.alpha(0.5f)
				.setStartDelay(500);


		PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("scaleX", 0.5f);
		PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleY", 0.5f);
		PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("alpha", 0.5f);

		ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, holder1, holder2, holder3);
		objectAnimator.setStartDelay(500);
		objectAnimator.start();

	}
}
