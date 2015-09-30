package com.example.ahmadfauzi.materialdesigntry;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Ahmad Fauzi on 9/16/2015.
 */
public class MyLayout extends FrameLayout {
    public static final String TAG = "MaterialDesign";
    Paint paint = null;
    public MyLayout(Context context) {
        super(context);
        init();
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();

        paint.setAntiAlias(true);
        setWillNotDraw(false);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event){
        switch(event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MyLayout dispatchTouchEvent: DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MyLayout dispatchTouchEvent: MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MyLayout dispatchTouchEvent: UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MyLayout dispatchTouchEvent: CANCEL");
                break;
        }
        boolean b = super.dispatchTouchEvent(event);
        Log.d(TAG, "MyLayout dispatchTouchEvent: RETURN " + b);
        return b;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event){
        switch(event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MyLayout onInterceptTouchEvent: DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MyLayout onInterceptTouchEvent: MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MyLayout onInterceptTouchEvent: UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MyLayout onInterceptTouchEvent: CANCEL");
                break;
        }
        boolean b = super.onInterceptTouchEvent(event);
        Log.d(TAG, "MyLayout onInterceptTouchEvent: RETURN "+ b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getActionMasked())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MyLayout onTouchEvent: DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MyLayout onTouchEvent: MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MyLayout onTouchEvent: UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MyLayout onTouchEvent: CANCEL");
                break;
        }
        boolean b = super.onTouchEvent(event);
        Log.d(TAG, "MyLayout onTouchEvent: RETURN "+ b);
        return b;
    }
}
