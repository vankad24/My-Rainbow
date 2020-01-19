package com.example.myrainbow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    MyThread thread;
    boolean status=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.stop);

    }

    public void onClick(View view){
        if (status){
            thread = MyRainbow.thread;
            thread.setRunning(false);
        }
        else{

        }
    }
}
