package com.example.myrainbow;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class MyThread extends Thread {

    SurfaceHolder holder;
    boolean isRunning;
    long lastTime=0;


    public MyThread(SurfaceHolder holder) {
        this.holder = holder;
    }

    @Override
    public void run() {
        super.run();
        int[] RGB=new int[3];
        boolean plus = true;
        int m = 2,value=0;
        RGB[0] = 255;
        while (isRunning) {

            if (System.currentTimeMillis() - lastTime > 20) {
                Canvas canvas = holder.lockCanvas();
                lastTime = System.currentTimeMillis();
                if (canvas != null) {
                    value+=(plus ? 1 : -1);
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

}

