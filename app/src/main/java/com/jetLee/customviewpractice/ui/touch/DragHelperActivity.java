package com.jetLee.customviewpractice.ui.touch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jetLee.customviewpractice.R;

/**
 * @author：Jet啟思
 * @date:2018/8/22 16:04
 */
public class DragHelperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_helper_grid_view);
    }
}
