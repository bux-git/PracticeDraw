package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.RectBean;
import com.hencoder.hencoderpracticedraw1.Util;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {
    private static final String TAG = "Practice10HistogramView";
    //原点坐标
    private float originX;
    private float originY;
    //终点坐标
    private float endY;
    private float endX;

    //Y轴最大值
    private float yMaxValue = 1000;

    //矩形间隔
    private float rectMargin =  Util.dp2px(6);
    //单个矩形宽度
    private float rectWidth;
    //Y轴每一份的像素数 长度
    private float yEachLength;

    private int minSize = 7;
    private List<RectBean> mRectBeans;

    Path mPath = new Path();
    private Paint mPaint = new Paint();

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mRectBeans = new ArrayList<>();
        mRectBeans.add(new RectBean("Froyo", 40));
        mRectBeans.add(new RectBean("GB", 80));
        mRectBeans.add(new RectBean("ICS", 90));
        mRectBeans.add(new RectBean("JB", 350));
        mRectBeans.add(new RectBean("KitKat", 800));
        mRectBeans.add(new RectBean("L", 900));
        mRectBeans.add(new RectBean("M", 300));

        minSize = mRectBeans.size() > minSize ? mRectBeans.size() : minSize;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //原点坐标
        originX = getWidth() / 6;
        originY = getHeight() * 5 / 6;

        //终点坐标
        endX = getWidth() - originX;
        endY = getHeight() - originY;


        //矩形宽度
        rectWidth = (endX - originX - minSize * rectMargin) / minSize;
        //Y轴每一份长度
        yEachLength = (originY-endY) / yMaxValue;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        //画出坐标系
        mPaint.setStrokeWidth(Util.dp2px(1));
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.moveTo(originX, endY);
        mPath.lineTo(originX, originY);
        mPath.lineTo(endX, originY);

        canvas.drawPath(mPath, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < mRectBeans.size(); i++) {

            RectBean rectBean = mRectBeans.get(i);
            if (rectBean.getValue() > (yMaxValue / 10)) {
                mPaint.setColor(Color.GREEN);
            }
            float left = originX + (i + 1) * rectMargin+i*rectWidth;
            float top = originY-yEachLength*rectBean.getValue();
            float right = left + rectWidth;
            float bottom = originY;
            Log.d(TAG, "onDraw: left:"+left +" top:"+top+" right:"+right+" bottom:"+bottom+"    yEachLength:"+yEachLength);
            canvas.drawRect(left, top, right, bottom, mPaint);

            mPaint.setTextSize(Util.dp2px(12));
            canvas.drawText(rectBean.getName(),left,originY+Util.dp2px(15),mPaint);
        }

    }
}
