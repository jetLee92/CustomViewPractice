package com.jetLee.customviewpractice.ui.property;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jetLee.customviewpractice.R;

/**
 * @author：Jet啟思
 * @date:2018/7/26 17:07
 */
public class PropertyMainActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_main);

		findViewById(R.id.objectAnimator).setOnClickListener(this);
		findViewById(R.id.typeEvaluator).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.objectAnimator:
				startActivity(this, PropertyAnimatorActivity.class);
				break;
			case R.id.typeEvaluator:
				startActivity(this, TypeEvaluatorActivity.class);
				break;
			default:
				break;
		}
	}

	private void startActivity(Context source, Class directionAct) {
		Intent intent = new Intent(source, directionAct);
		startActivity(intent);
	}


}
