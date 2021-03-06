package com.jetLee.customviewpractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jetLee.customviewpractice.ui.CanvasMatrixCamera.ClipActivity;
import com.jetLee.customviewpractice.ui.CircleAvatarActivity;
import com.jetLee.customviewpractice.ui.DashBoardActivity;
import com.jetLee.customviewpractice.ui.measurelayout.MeasureLayoutActivity;
import com.jetLee.customviewpractice.ui.PieChartActivity;
import com.jetLee.customviewpractice.ui.SportActivity;
import com.jetLee.customviewpractice.ui.property.PropertyMainActivity;
import com.jetLee.customviewpractice.ui.touch.Touch1Activity;
import com.jetLee.customviewpractice.ui.touch.TouchMainActivity;

/**
 * @Author：Jet啟思
 * @Date:2018/7/24 15:02
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		findViewById(R.id.dashBoard).setOnClickListener(this);
		findViewById(R.id.pieChart).setOnClickListener(this);
		findViewById(R.id.circleAvatar).setOnClickListener(this);
		findViewById(R.id.sport).setOnClickListener(this);
		findViewById(R.id.property).setOnClickListener(this);
		findViewById(R.id.clip).setOnClickListener(this);
		findViewById(R.id.measureAndLayout).setOnClickListener(this);
		findViewById(R.id.touch).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.dashBoard:
				startActivity(this, DashBoardActivity.class);
				break;
			case R.id.pieChart:
				startActivity(this, PieChartActivity.class);
				break;
			case R.id.circleAvatar:
				startActivity(this, CircleAvatarActivity.class);
				break;
			case R.id.sport:
				startActivity(this, SportActivity.class);
				break;
			case R.id.property:
				startActivity(this, PropertyMainActivity.class);
				break;
			case R.id.clip:
				startActivity(this, ClipActivity.class);
				break;
			case R.id.measureAndLayout:
				startActivity(this, MeasureLayoutActivity.class);
				break;
			case R.id.touch:
				startActivity(this, TouchMainActivity.class);
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
