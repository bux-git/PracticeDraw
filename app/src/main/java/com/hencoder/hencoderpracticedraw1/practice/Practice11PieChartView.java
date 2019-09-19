package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.RectBean;
import com.hencoder.hencoderpracticedraw1.Util;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {
    private static final String TAG = "Practice11PieChartView";

    private List<RectBean> mRectBeans;
    //间隔角度
    private int marginAngle = 2;
    //每一份得角度
    private float eachAngle;

    private RectF mRectF;
    private Paint mPaint;

    private float radius;

    private float pulled_length = Util.dp2px(12);

    private int pulled_index = 5;

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mRectBeans = new ArrayList<>();
        mRectBeans.add(new RectBean("Froyo", 40, Color.YELLOW));
        mRectBeans.add(new RectBean("GB", 80, Color.RED));
        mRectBeans.add(new RectBean("ICS", 90, Color.BLUE));
        mRectBeans.add(new RectBean("JB", 50, Color.GREEN));
        mRectBeans.add(new RectBean("KitKat", 100, Color.WHITE));
        mRectBeans.add(new RectBean("L", 200, Color.GRAY));
        mRectBeans.add(new RectBean("M", 300, Color.MAGENTA));

        eachAngle = (360f - mRectBeans.size() * marginAngle) / RectBean.totalCount;

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(Util.dp2px(12));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        radius = getWidth() * 2.5f / 10;
        mRectF = new RectF((getWidth() / 2f) - radius, (getHeight() / 2f) - radius, (getWidth() / 2f) + radius, (getHeight() / 2f) + radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        float curAngle = marginAngle;

        for (int i = 0; i < mRectBeans.size(); i++) {

            RectBean rectBean = mRectBeans.get(i);
            float startAngle = curAngle;
            float sweepAngle = eachAngle * rectBean.getValue();
            mPaint.setColor(rectBean.getColor());

            float radians = (float) Math.toRadians(startAngle + sweepAngle / 2);

            //选中抽出
            if (pulled_index == i) {
                canvas.save();

                float x = (float) (pulled_length * Math.cos(radians));
                float y = (float) (pulled_length * Math.sin(radians));

                canvas.translate(x, y);
                canvas.drawArc(mRectF, startAngle, sweepAngle, true, mPaint);
                canvas.restore();
                drawText(canvas, rectBean, radians,getWidth()/2f+x,getHeight()/2f+y);
            }else{
                canvas.drawArc(mRectF, startAngle, sweepAngle, true, mPaint);
                drawText(canvas, rectBean, radians,getWidth()/2f,getHeight()/2f);
            }



            curAngle = marginAngle + sweepAngle + startAngle;

        }
    }

    private void drawText(Canvas canvas, RectBean rectBean, float radians,float rx,float ry) {
        mPaint.setColor(Color.BLACK);
        //文字
        float x = (float) (radius * Math.cos(radians))+rx;
        float y = (float) (radius * Math.sin(radians))+ry;
        canvas.drawText(rectBean.getName(), x, y, mPaint);
        Log.d(TAG, "onDraw: "+x+" "+y);
    }
}
