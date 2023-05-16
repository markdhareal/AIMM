package com.app.applicationquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView txtView,progressBarPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtView = (TextView) findViewById(R.id.quizText);
        progressBarPercentage = (TextView) findViewById(R.id.progressPercentage);
        progressBar = (ProgressBar) findViewById(R.id.progressBarId);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressBarAnimationMethod();
    }

    public void progressBarAnimationMethod()
    {
        ProgressBarAnimation progressAnimation = new ProgressBarAnimation(this, progressBar, progressBarPercentage, 0f, 100f);
        progressAnimation.setDuration(8000);
        progressBar.setAnimation(progressAnimation);
    }
}