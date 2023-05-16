package com.app.applicationquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PlayTutorial extends AppCompatActivity {

    Button play, tutorial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_tutorial);

        String getSelectedQuiz = getIntent().getStringExtra("Game");
        String getSelectedTutorial = getIntent().getStringExtra("Tutorial");


        play = (Button) findViewById(R.id.play);
        tutorial = (Button) findViewById(R.id.tutorial);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if(getSelectedQuiz.equals("combinations"))
                {
                    intent = new Intent(PlayTutorial.this, CombinationQuiz.class);
                    startActivity(intent);
                }
                else
                {
                    intent = new Intent(PlayTutorial.this, PlayQuiz.class);
                    intent.putExtra("GameQuiz",getSelectedQuiz);
                    startActivity(intent);
                }
            }
        });

        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tutorialIntent = new Intent(PlayTutorial.this, TutorialActivity.class);
                tutorialIntent.putExtra("TutorialName", getSelectedTutorial);
                startActivity(tutorialIntent);
            }
        });
    }
}