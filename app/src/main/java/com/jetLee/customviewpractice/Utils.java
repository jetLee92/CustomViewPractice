package com.jetLee.customviewpractice;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * @Author：Jet啟思
 * @Date:2018/7/24 15:07
 */
public class Utils {

	public static int dpToPx(int dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
	}

}
