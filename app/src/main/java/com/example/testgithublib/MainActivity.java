package com.example.testgithublib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity {

    private ProgressBarView0 progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);
        // 设置进度条颜色和背景颜色 ============ =============
        testBar();
    }

    private void testBar() {
        progressBar.setArcAngle(180);
        progressBar.setMaxValue(360);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    num++;
                    if (num>360) {
                        num = 0;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mHandler.sendEmptyMessage(1);
                }
            }
        }).start();
    }

    int num = 0;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            progressBar.setProgress(num);
            return false;
        }
    });
}