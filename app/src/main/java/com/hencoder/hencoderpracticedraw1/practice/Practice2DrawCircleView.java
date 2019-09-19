package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Util;

public class Practice2DrawCircleView extends View {

    //宽高的 一半
    private float halfWidth;
    private float halfHeight;

    //半径
    private int radius;

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        halfWidth=getWidth()/2f;
        halfHeight=getHeight()/2f;
        radius = (int) (halfHeight / 2 - Util.dp2px(20));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        canvas.drawCircle(halfWidth/2,halfHeight/2,radius,mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(Util.dp2px(5));

        canvas.drawCircle(halfWidth+(halfWidth/2),halfHeight/2,radius,mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((halfWidth/2),halfHeight+halfHeight/2,radius,mPaint);

        mPaint.setStrokeWidth(Util.dp2px(20));
        mPaint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(halfWidth+(halfWidth/2),halfHeight+halfHeight/2,radius,mPaint);
    }
}
