package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice9DrawPathView extends View {

    private static final String TAG = "Practice9DrawPathView";
    int xOffset = 100;
    int yOffset = 100;

    Paint mPaint = new Paint();
    Path mPath = new Path();

    int startX;
    int startY;
    private RectF arcRectF;

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        startX = getWidth() / 2;
        startY = getHeight() * 3 / 4;

        arcRectF = new RectF(startX - xOffset, startY - yOffset, startX, startY);
        Log.d(TAG, "onSizeChanged: " + startX + "  y:" + startY);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形


        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        mPath.moveTo(startX, startY);
        mPath.lineTo(startX - xOffset, startY - yOffset);

        mPath.lineTo(startX - xOffset, startY - yOffset);
        mPath.addArc(arcRectF, 150, 180);


        canvas.drawPath(mPath, mPaint);
    }
}
