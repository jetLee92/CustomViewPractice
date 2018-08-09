package com.jetLee.customviewpractice.ui.measurelayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jetLee.customviewpractice.R;

/**
 * @author：Jet啟思
 * @date:2018/8/6 14:35
 */
public class MeasureLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_measure_layout);

        initView();
    }

    private void initView() {
        findViewById(R.id.circle).setOnClickListener(this);
        findViewById(R.id.tagLayout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.circle:
                startActivity(this, CircleActivity.class);
                break;
            case R.id.tagLayout:
                startActivity(this,FlowTagLayoutActivity.class);
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
