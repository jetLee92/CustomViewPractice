package com.jetLee.customviewpractice.ui.touch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jetLee.customviewpractice.R;

/**
 * @author：Jet啟思
 * @date:2018/8/22 10:41
 */
public class TouchMainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_main);

        findViewById(R.id.multiTouch).setOnClickListener(this);
        findViewById(R.id.pageView).setOnClickListener(this);
        findViewById(R.id.dragListener).setOnClickListener(this);
        findViewById(R.id.dragHelper).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.multiTouch:
                startActivity(this, Touch1Activity.class);
                break;
            case R.id.pageView:
                startActivity(this, PageViewActivity.class);
                break;
            case R.id.dragListener:
                startActivity(this, DragListenerActivity.class);
                break;
            case R.id.dragHelper:
                startActivity(this, DragHelperActivity.class);
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
