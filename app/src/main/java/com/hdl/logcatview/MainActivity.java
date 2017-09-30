package com.hdl.logcatview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int i = 0;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String line = (String) msg.obj;
            if (line.contains("E")) {
                tvLog.append("\n");
                tvLog.append(Html.fromHtml("<font color='red'>"+line+"</font>"));

            } else {
                tvLog.append("\n" + line);
            }
            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
        }
    };
    private TextView tvLog;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLog = (TextView) findViewById(R.id.tv_consol);
        scrollView = (ScrollView) findViewById(R.id.sv);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                i++;
                Log.v("hdltag", "onCreate(MainActivity.java:40):" + i);
                Log.d("hdltag", "onCreate(MainActivity.java:41):" + i);
                Log.w("hdltag", "onCreate(MainActivity.java:42):" + i);
                Log.e("hdltag", "onCreate(MainActivity.java:43):" + i);
            }
        }, 0, 2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Process logcatProcess = null;
                BufferedReader bufferedReader = null;
                StringBuilder log = new StringBuilder();
                String line;
                try {
                    while (true) {
                        logcatProcess = Runtime.getRuntime().exec("logcat");
                        bufferedReader = new BufferedReader(new InputStreamReader(logcatProcess.getInputStream()));
                        while ((line = bufferedReader.readLine()) != null) {
                            log.append(line);
                            Message message = mHandler.obtainMessage();
                            message.what = 0;
                            message.obj = line;
                            mHandler.sendMessage(message);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
