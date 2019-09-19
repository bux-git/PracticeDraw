package com.hencoder.hencoderpracticedraw1;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * description：
 * author：bux on 2019/9/18 11:06
 * email: 471025316@qq.com
 */
public class Util {

    public static float dp2px(int dp){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
