package com.example.myrainbow;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class MyThread extends Thread {

    SurfaceHolder holder;
    boolean isRunning;

    long lastTime;

    static int[] RGB={255,0,0};
    static boolean plus = true;
    static int m = 2,value=0;

    public MyThread(SurfaceHolder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        super.run();
        int addColor = 5;
        Canvas canvas;
        if (!isRunning){
            canvas = holder.lockCanvas();
            canvas.drawColor(Color.rgb(RGB[0],RGB[1],RGB[2]));
            holder.unlockCanvasAndPost(canvas);
        }
        while (isRunning) {
            if (System.currentTimeMillis() - lastTime > 40) {
                canvas = holder.lockCanvas();
                lastTime = System.currentTimeMillis();
                if (canvas != null) {
                    value+=(plus ? addColor : -addColor);
                    RGB[m]=value;
                    if (value==255||value==0) {
                        m = (m + 1) % 3;
                        plus = !plus;
                    }

                    canvas.drawColor(Color.rgb(RGB[0],RGB[1],RGB[2]));
                    holder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
    public void setRunning(boolean running) {
        isRunning = running;
    }
    public boolean getRunning() {
        return isRunning;
    }

}

