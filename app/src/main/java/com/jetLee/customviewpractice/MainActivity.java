package com.jetLee.customviewpractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jetLee.customviewpractice.ui.DashBoardActivity;
import com.jetLee.customviewpractice.ui.PieChartActivity;

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
			default:
				break;
		}
	}

	private void startActivity(Context source, Class directionAct) {
		Intent intent = new Intent(source, directionAct);
		startActivity(intent);
	}
}
