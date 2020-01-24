package com.example.myrainbow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int clicks;
    MyRainbow rainbow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rainbow= new MyRainbow(this);
    }

    public void onClick(View view){
        if (clicks==0){
            rainbow.thread.setRunning(false);
            try {
                rainbow.thread.join();
            }catch (Exception e){}

        }else if (clicks==1){
            rainbow.thread.setRunning(true);
            rainbow.thread.start();
        }

        clicks=(clicks+1)%2;
    }

}
