package com.app.applicationquizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WholeQuizResult extends AppCompatActivity {

    private TextView topicOne, topicTwo, topicThree, topicFour, scoreTotal;
    private TextView timeOne, timeTwo, timeThree, timeFour;
    private Button clearWholeResult,finishWholeResult;

    int scoreTopicOne = 0, scoreTopicTwo = 0, scoreTopicThree = 0, scoreTopicFour = 0, total = 0;
    String timeTopicOne = "", timeTopicTwo = "", timeTopicThree = "", timeTopicFour = "";

    String getQuizResult = "";

    SharedPreferences getResult, getResultComb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole_quiz_result);

        // = getIntent().getStringExtra("wholeQuizResults");

        topicOne = findViewById(R.id.scoreTopicOne);
        topicTwo = findViewById(R.id.scoreTopicTwo);
        topicThree = findViewById(R.id.scoreTopicThree);
        topicFour = findViewById(R.id.scoreTopicFour);
        scoreTotal = findViewById(R.id.totalScoreText);

        timeOne = findViewById(R.id.timeTopicOne);
        timeTwo = findViewById(R.id.timeTopicTwo);
        timeThree = findViewById(R.id.timeTopicThree);
        timeFour = findViewById(R.id.timeTopicFour);

        clearWholeResult = findViewById(R.id.clearWholeResultId);
        finishWholeResult = findViewById(R.id.finishWholeResultId);

        //MAIN RESULT
        getResult = getApplicationContext().getSharedPreferences("QuizResult", Context.MODE_PRIVATE);
        //COMBINATION RESULT
        getResultComb = getApplicationContext().getSharedPreferences("QuizResultComb", Context.MODE_PRIVATE);

        //GET SHAREDPREFS BY PAIR (SCORE)
        scoreTopicOne = getResult.getInt("resultScoreIntPerm", 0);
        scoreTopicTwo = getResultComb.getInt("resultScoreIntComb", 0);
        scoreTopicThree = getResult.getInt("resultScoreIntComForm", 0);
        scoreTopicFour = getResult.getInt("resultScoreIntPermPermOrCom", 0);

        //GET SHAREDPREFS BY PAIR (TIME)
        timeTopicOne = getResult.getString("resultTimeTextPerm", "00:00");
        timeTopicTwo = getResultComb.getString("resultTimeTextComb", "00:00");
        timeTopicThree = getResult.getString("resultTimeTextComForm", "00:00");
        timeTopicFour = getResult.getString("resultTimeTextPermOrCom", "00:00");

        //DISPLAY DATA
        topicOne.setText(scoreTopicOne+" / 5");
        timeOne.setText(timeTopicOne);

        topicTwo.setText(scoreTopicTwo+" / 10");
        timeTwo.setText(timeTopicTwo);

        topicThree.setText(scoreTopicThree+" / 5");
        timeThree.setText(timeTopicThree);

        topicFour.setText(scoreTopicFour+" / 5");
        timeFour.setText(timeTopicFour);

        total = scoreTopicOne + scoreTopicTwo + scoreTopicThree + scoreTopicFour;
        scoreTotal.setText(total+" / 25");

        clearWholeResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearWholeResult();
                topicOne.setText("0 / 5");
                timeOne.setText("00:00");

                topicTwo.setText("0 / 10");
                timeTwo.setText("00:00");

                topicThree.setText("0 / 5");
                timeThree.setText("00:00");

                topicFour.setText("0 / 5");
                timeFour.setText("00:00");

                scoreTotal.setText("0 / 25");

                Toast.makeText(WholeQuizResult.this, "Data Cleared", Toast.LENGTH_SHORT).show();
            }
        });

        finishWholeResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHome = new Intent(WholeQuizResult.this, HomeActivity.class);
                startActivity(goHome);
            }
        });
    }

    public void clearWholeResult()
    {
        ResultAct.clearData(this);
        ResultActComb.clearComb(this);
    }
}