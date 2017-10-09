package com.hdl.logcatview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.hdl.logcatdialog.LogcatDialog;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                i++;
                System.out.println("sys----" + i);
                Log.v("tj", "111111111111-" + i);
                Log.d("hyd", "00000000000000---------" + i);
                Log.w("lv", "onCreate(MainActivity.java:42):https://www.baidu.com/title=" + i);
                Log.e("lcl", "onCreate(MainActivity.java:43):https://www.baidu.com");
            }
        }, 0, 1000);
        Log.e("hdltag", "onCreate(Main2Activity.java:29):大哥");
    }

    public void onTest(View view) {
        new LogcatDialog(this).show();
    }
}
