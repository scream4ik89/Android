package com.itacademy.myapplication.ClassWork4;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {
    private Paint paint;
    private float radius;
    private float cx;
    private float cy;
    private RectF rect;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx = w / 2;
        cy = h / 2;
        radius = w > h ? cy / 4 : cx / 4;

        rect = new RectF();
        float wRec = w * 0.9f; // w / 100% * 90%
        float hRec = h * 0.2f; // h / 100% * 20%


        rect.left = (w - wRec) / 2;
        rect.right = (h - hRec) / 2;
        rect.top = w - rect.left;
        rect.bottom = h - rect.top;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        invalidate(); // перересовка
        canvas.drawCircle(cx, cy, radius, paint);
        //canvas.drawLine(0,0, 100, 100, paint);
        //canvas.drawRect(rect,paint);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { // указывается сколько
        // необходимо места для отрисовки объекта
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: { //палец опустили на экран
                break;
            }
            case MotionEvent.ACTION_UP: { //палец подняли с экрана
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                cx = event.getX();
                cy = event.getY();
                invalidate();
                return false;
            }
        }
        return true;
    }

}


