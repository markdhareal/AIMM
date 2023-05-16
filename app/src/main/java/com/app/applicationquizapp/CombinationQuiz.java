package com.app.applicationquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

public class CombinationQuiz extends AppCompatActivity {

    private ImageView imageQuestionCounter;
    private TextView questionTextview;
    private TextView scoreComb;
    private TextView optionOne;
    private TextView optionTwo;
    private Chronometer timerComb;//Chronometer - Timer

    RadioGroupPlus radioGroupPlus;
    private RadioButton radioButtonOne;
    private RadioButton radioButtonTwo;

    private Button confirmButton;
    private Button resultButton;

    private LinearLayout linearLayoutOne;
    private LinearLayout linearLayoutTwo;

    private int scoreNumber = 0;
    private int questionCounterComb;
    private int questionTotalComb;

    private List<Questions> questionsListComb;
    private Questions currentQuestionComb;

    private boolean answeredComb;

    private int currentImageComb = 0;
    int[] imagesComb = {R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six,
            R.drawable.seven, R.drawable.eight, R.drawable.nine,
            R.drawable.ten};

    String timeTextComb = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combination_quiz);


        timerComb = findViewById(R.id.timerTextComb);
        scoreComb = findViewById(R.id.scoreViewComb);
        imageQuestionCounter = findViewById(R.id.questionNumberComb);
        questionTextview = findViewById(R.id.questionViewComb);
        optionOne = findViewById(R.id.optionTextOneComb);
        optionTwo = findViewById(R.id.optionTextTwoComb);
        radioGroupPlus = findViewById(R.id.radioGroupComb);
        radioButtonOne = findViewById(R.id.option1Comb);
        radioButtonTwo = findViewById(R.id.option2Comb);
        confirmButton = findViewById(R.id.confirmBtnComb);
        resultButton = findViewById(R.id.resultBtnComb);

        linearLayoutOne = findViewById(R.id.layoutOneComb);
        linearLayoutTwo = findViewById(R.id.layoutTwoComb);

        questionsListComb = new ArrayList<>();
        getQuiz(questionsListComb);

        questionTotalComb = questionsListComb.size();

        startTime();//Timer
        showNextQuestion();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answeredComb)
                {
                    if(radioButtonOne.isChecked() || radioButtonTwo.isChecked())
                    {
                        checkAnswer();
                    }
                    else
                    {
                        Toast.makeText(CombinationQuiz.this, "Please select your answer",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    showNextQuestion();

                }
            }
        });

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultComb = new Intent(CombinationQuiz.this, ResultActComb.class);
                resultComb.putExtra("timeComb", timeTextComb);
                resultComb.putExtra("scoreComb", scoreNumber);
                startActivity(resultComb);
            }
        });

    }

    private void showNextQuestion()
    {
        linearLayoutOne.setBackgroundResource(R.drawable.background_options);
        linearLayoutTwo.setBackgroundResource(R.drawable.background_options);

        radioGroupPlus.clearCheck();
        confirmButton.setText("Confirm");

        if(questionCounterComb < questionTotalComb)
        {
            currentQuestionComb = questionsListComb.get(questionCounterComb);

            questionTextview.setText(currentQuestionComb.getQuestion());
            optionOne.setText(currentQuestionComb.getOption1());
            optionTwo.setText(currentQuestionComb.getOption2());

            imageQuestionCounter.setImageResource(imagesComb[currentImageComb]);
            currentImageComb++;

            questionCounterComb++;
            answeredComb = false;
            resultButton.setEnabled(false);
        }
        else
        {
            confirmButton.setEnabled(false);
            resultButton.setEnabled(true);
            timerComb.stop();
            timeTextComb = timerComb.getText().toString();
            //confirmButton.setText(timeTextComb);//iisipin pa
        }
    }

    private void checkAnswer()
    {
        answeredComb = true;

        int id = radioGroupPlus.getCheckedRadioButtonId();
        int userAnswerNumber = 0;

        switch (id)
        {
            case R.id.option1Comb:
                userAnswerNumber = 1;
                break;

            case R.id.option2Comb:
                userAnswerNumber = 2;
                break;
        }

        if (userAnswerNumber == currentQuestionComb.getUserAnswer())
        {
            scoreNumber++;
            scoreComb.setText("Score: "+scoreNumber);
        }

        showRightSolutionComb();
    }

    private void showRightSolutionComb()
    {
        linearLayoutOne.setBackgroundResource(R.drawable.background_wrong);
        linearLayoutTwo.setBackgroundResource(R.drawable.background_wrong);

        switch (currentQuestionComb.getUserAnswer())
        {
            case 1:
                linearLayoutOne.setBackgroundResource(R.drawable.background_correct);
                break;
            case 2:
                linearLayoutTwo.setBackgroundResource(R.drawable.background_correct);
                break;
        }

        if (questionCounterComb < questionTotalComb)
        {
            confirmButton.setText("Next");
        }
    }

    private void getQuiz(List<Questions> quizQuestionList)
    {
        quizQuestionList.add(new Questions("Tell whether the following statements are Combination or Permutation.\nSelecting the members of a dance troupe.", "Combination", "Permutation", 1));
        quizQuestionList.add(new Questions("Tell whether the following statements are Combination or Permutation.\nRecognizing honors from a graduate class.","Combination", "Permutation", 2));
        quizQuestionList.add(new Questions("Tell whether the following statements are Combination or Permutation.\nPutting make up on the face.", "Combination", "Permutation",2));
        quizQuestionList.add(new Questions("Tell whether the following statements are Combination or Permutation.\nAssigning quarters for volunteers.", "Combination", "Permutation",1));
        quizQuestionList.add(new Questions("Tell whether the following statements are Combination or Permutation.\nTravelling around the Philippines, one place at a time.", "Combination", "Permutation",2));
        quizQuestionList.add(new Questions("Tell whether the following statements are Combination or Permutation.\nChoosing dress to wear from a closet.", "Combination", "Permutation",1));
        quizQuestionList.add(new Questions("Tell whether the following statements are Combination or Permutation.\nTravelling around the world.", "Combination", "Permutation",1));
        quizQuestionList.add(new Questions("Tell whether the following statements are Combination or Permutation.\nHarvesting fruits from a tree.", "Combination", "Permutation",1));
        quizQuestionList.add(new Questions("Tell whether the following statements are Combination or Permutation.\nTaking pictures at Luneta Park in a row.", "Combination", "Permutation",2));
        quizQuestionList.add(new Questions("Tell whether the following statements are Combination or Permutation.\nForming lines from 6 given points but no four of which are collinear.", "Combination", "Permutation",2));

    }

    private void startTime()
    {
        int stoppedMillSeconds = 0;
        String chronometerTime = timerComb.getText().toString();
        String[] array = chronometerTime.split(":");

        if (array.length == 2)
        {
            stoppedMillSeconds = Integer.parseInt(array[0]) * 60 * 1000 + Integer.parseInt(array[1]) * 1000;
        }
        else if (array.length == 3)
        {
            stoppedMillSeconds = Integer.parseInt(array[0]) * 60 * 60 * 1000 + Integer.parseInt(array[1]) * 60 * 1000 + Integer.parseInt(array[2]) * 1000;
        }

        timerComb.setBase(SystemClock.elapsedRealtime() - stoppedMillSeconds);

        timerComb.start();
    }
}