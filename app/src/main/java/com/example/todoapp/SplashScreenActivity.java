package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash_screen );

        logo = findViewById( R.id.logo );

        Animation animation = AnimationUtils.loadAnimation( this,R.anim.splashanimation );
        logo.startAnimation( animation );

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setFlags( WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                    finish();
                }catch (Exception e) {

                }
            }
        };

        thread.start();
    }
}