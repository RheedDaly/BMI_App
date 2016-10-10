package com.rheedkhadaly.familyweightmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timer = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent a = new Intent("com.rheedkhadaly.familyweightmanager.MAINACTIVITY");
                    startActivity(a);
                }
            }
        };
        timer.start();
    }
}
