package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint mPaint=new Paint();
    private RectF rectf;

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectf = new RectF(getWidth() / 4, getHeight() / 4, getWidth() * 3 / 4, getHeight() * 3 / 4);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        canvas.drawArc(rectf,30,120,false,mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectf,170,40,false,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectf,230,120,true,mPaint);
    }
}
