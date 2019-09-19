package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

/**
 * description：
 * author：bux on 2019/9/19 16:31
 * email: 471025316@qq.com
 */
public class PracticePorterDuffView extends View {

    Paint mPaint = new Paint();
    Shader mShaderA;
    Shader mShaderB;
    public PracticePorterDuffView(Context context) {
        super(context);
    }

    public PracticePorterDuffView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PracticePorterDuffView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PracticePorterDuffView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        Bitmap bitmapA = BitmapFactory.decodeResource(getResources(), R.drawable.rect);
        mShaderA = new BitmapShader(bitmapA, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Bitmap bitmapB = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        mShaderB = new BitmapShader(bitmapB, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        ColorFilter colorFilter=new LightingColorFilter(0x00ffff,0x000000);
        mPaint.setColorFilter(colorFilter);
        mPaint.setShader(new ComposeShader(mShaderA,mShaderB, PorterDuff.Mode.SRC_OVER));
        //mPaint.setShader(mShaderB);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,0,400,400,mPaint);
    }
}
