package com.itacademy.homework.homework4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;


import java.util.Calendar;


public class HomeWork4View extends View {
    private int mHeight, mWidth = 0;
    private int[] mClockHours = {3, 6, 9, 12};
    private float mPadding = 0;
    private float mNumeralSpacing = 0;
    private float mHandTruncation, mHourHandTruncation = 0;
    private float mRadius = 0;
    private Paint mPaint;
    private Rect mRect = new Rect();
    private RectF dash;

    public HomeWork4View(Context context) {
        super(context);
    }
    public HomeWork4View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HomeWork4View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        dash = new RectF();
        dash.left = mWidth / 2 - (mRadius * 0.01f);
        dash.right = mWidth / 2 + (mRadius * 0.01f);
        dash.top = mHeight / 2 - (mRadius + mRadius * 0.03f);
        dash.bottom = mHeight / 2 - (mRadius - mRadius * 0.15f);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint = new Paint();
        mHeight = getHeight();
        mWidth = getWidth();
        mPadding = mNumeralSpacing + 120;
        int minAttr = Math.min(mHeight, mWidth);
        mRadius = minAttr / 2 - mPadding;
        mHandTruncation = minAttr / 20;
        mHourHandTruncation = minAttr / 10;
        //canvas.drawColor(Color.DKGRAY);
        mPaint.reset();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(15);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mRadius + mPadding - 40, mPaint);


        for (int i = 0; i < 60; i++) {
            double angle = Math.PI  ;
            int x = (int) (mWidth / 2 + Math.cos(angle) * mRadius - mRect.width() / 2);
            int y = (int) (mHeight / 2 + Math.sin(angle) * mRadius + mRect.height() / 14);
            canvas.drawPoint(x, y, mPaint);
            canvas.rotate(6, mWidth / 2, mHeight / 2);
            canvas.save();
            canvas.restore();
        }
        for (int i = 0; i < 12; i++) {
            if (i % 3 != 0) {
                double angle = Math.PI;
                int x = (int) (mWidth / 2 + Math.cos(angle) * mRadius - mRect.width() / 8);
                int y = (int) (mHeight / 2 + Math.sin(angle) * mRadius + mRect.height() / 14);
                mPaint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(x, y, 25, mPaint);
            }
            canvas.rotate(30, mWidth / 2, mHeight / 2);
            canvas.save();
            canvas.restore();
        }
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(mWidth / 2, mHeight / 2, 14, mPaint);
        int fontSize = (int) TypedValue.applyDimension
                (TypedValue.COMPLEX_UNIT_SP, 30, getResources().getDisplayMetrics());
        mPaint.setTextSize(fontSize);

        for (int hour : mClockHours) {
            String tmp = String.valueOf(hour);
            mPaint.getTextBounds(tmp, 0, tmp.length(), mRect);


            double angle = Math.PI / 6 * (hour - 3);
            int x = (int) (mWidth / 2 + Math.cos(angle) * mRadius - mRect.width() / 2);
            int y = (int) (mHeight / 2 + Math.sin(angle) * mRadius + mRect.height() / 2);

            mPaint.setColor(Color.BLACK);
            canvas.drawText(String.valueOf(hour), x, y, mPaint);

            Calendar calendar = Calendar.getInstance();
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            hour = hour > 12 ? hour - 12 : hour;

            drawHandLine(canvas, (hour + calendar.get(Calendar.MINUTE) / 60) * 5f, true, false); // draw hours
            drawHandLine(canvas, calendar.get(Calendar.MINUTE), false, false); // draw minutes
            drawHandLine(canvas, calendar.get(Calendar.SECOND), false, true); // draw seconds


            postInvalidateDelayed(500);
            invalidate();
        }
    }

    private void drawHandLine(Canvas canvas, double moment, boolean isHour, boolean isSecond) {
        double angle = Math.PI * moment / 30 - Math.PI / 2;
        float handRadius = isHour ? mRadius - mHandTruncation - mHourHandTruncation : mRadius - mHandTruncation;
        if (isSecond) {
            mPaint.setColor(Color.BLUE);
        } else {
            mPaint.setColor(Color.BLACK);
        }
        canvas.drawLine(mWidth / 2, mHeight / 2, (float) (mWidth / 2 + Math.cos(angle) * handRadius),
                (float) (mHeight / 2 + Math.sin(angle) * handRadius), mPaint);
    }

}
