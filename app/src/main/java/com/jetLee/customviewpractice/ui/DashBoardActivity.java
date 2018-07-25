package com.jetLee.customviewpractice.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.jetLee.customviewpractice.R;
import com.jetLee.customviewpractice.view.DashBoardView;

/**
 * @Author：Jet啟思
 * @Date:2018/7/25 10:29
 */
public class DashBoardActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		final DashBoardView view = findViewById(R.id.dashBoard);
		final EditText editText = findViewById(R.id.etValue);
		editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_SEND
						|| actionId == EditorInfo.IME_ACTION_DONE
						|| (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
					if (!TextUtils.isEmpty(editText.getText().toString().trim())) {
						view.setScaleValue(Integer.valueOf(editText.getText().toString().trim()));
					}
				}
				return false;
			}
		});
	}

}
