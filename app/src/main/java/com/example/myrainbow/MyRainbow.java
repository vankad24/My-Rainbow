package com.example.myrainbow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyRainbow extends SurfaceView implements SurfaceHolder.Callback {
    static MyThread thread;
    SurfaceHolder holder;
    boolean savedRunning=true;
    public MyRainbow(Context context, AttributeSet attrs) {
        super(context, attrs);
        holder=getHolder();
        holder.addCallback(this);
    }

    public MyRainbow(Context context) {
        super(context);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (thread==null) {
            thread = new MyThread(getHolder());
        }
            thread.setRunning(savedRunning);
            thread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        savedRunning= thread.getRunning();
        thread.setRunning(false);
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
