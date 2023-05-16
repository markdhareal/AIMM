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

import java.util.List;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

public class PlayQuiz extends AppCompatActivity {

    private TextView questionView;
    private TextView scoreTextView;
    private TextView optionOne;
    private TextView optionTwo;
    private TextView optionThree;
    private TextView optionFour;

    private ImageView questionNumber;
    RadioGroupPlus radioGroupPlus;
    private RadioButton radioBtn1;
    private RadioButton radioBtn2;
    private RadioButton radioBtn3;
    private RadioButton radioBtn4;
    private Button confirmBtn;
    private Button resultBtn;
    private Chronometer timer;

    private List<Questions> questionsList;
    private int questionCounter;
    private int questionsTotal;
    private Questions currentQuestion;

    private int score = 0;
    private boolean answered;

    private LinearLayout linearLayoutOne;
    private LinearLayout linearLayoutTwo;
    private LinearLayout linearLayoutThree;
    private LinearLayout linearLayoutFour;

    private int currentImage = 0;

    private int[] images = {R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five};

    String timeText = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_quiz);

        String getSelectedQuiz = getIntent().getStringExtra("GameQuiz");

        timer = findViewById(R.id.timerText);//Chronometer
        questionView = findViewById(R.id.questionView);
        scoreTextView = findViewById(R.id.scoreView);
        questionNumber = findViewById(R.id.questionNumber);
        radioGroupPlus = findViewById(R.id.radioGroup);
        radioBtn1 = findViewById(R.id.option1);
        radioBtn2 = findViewById(R.id.option2);
        radioBtn3 = findViewById(R.id.option3);
        radioBtn4 = findViewById(R.id.option4);
        optionOne = findViewById(R.id.optionTextOne);
        optionTwo = findViewById(R.id.optionTextTwo);
        optionThree = findViewById(R.id.optionTextThree);
        optionFour = findViewById(R.id.optionTextFour);
        confirmBtn = findViewById(R.id.confirmBtn);
        resultBtn = findViewById(R.id.resultBtnID);

        linearLayoutOne = findViewById(R.id.layoutOne);
        linearLayoutTwo = findViewById(R.id.layoutTwo);
        linearLayoutThree = findViewById(R.id.layoutThree);
        linearLayoutFour = findViewById(R.id.layoutFour);

        questionsList = QuestionBank.getQuestions(getSelectedQuiz);
        questionsTotal = questionsList.size();

        startTime();//start chronometer
        showNextQuestion();


        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answered)
                {
                    if(radioBtn1.isChecked() || radioBtn2.isChecked() || radioBtn3.isChecked() || radioBtn4.isChecked())
                    {
                        checkAnswer();
                    }
                    else
                    {
                        Toast.makeText(PlayQuiz.this, "Please select your answer.", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    showNextQuestion();
                }
            }
        });

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent(PlayQuiz.this, ResultAct.class);
                result.putExtra("QuizToResult",getSelectedQuiz);
                result.putExtra("time",timeText);//pass the time to result act
                result.putExtra("score", score);// pass the score to result activity
                startActivity(result);
            }
        });


    }

    private void showNextQuestion()
    {
        linearLayoutOne.setBackgroundResource(R.drawable.background_options);
        linearLayoutTwo.setBackgroundResource(R.drawable.background_options);
        linearLayoutThree.setBackgroundResource(R.drawable.background_options);
        linearLayoutFour.setBackgroundResource(R.drawable.background_options);

        radioGroupPlus.clearCheck();
        confirmBtn.setText("Confirm");

        if(questionCounter < questionsTotal)
        {
            currentQuestion = questionsList.get(questionCounter);

            questionView.setText(currentQuestion.getQuestion());
            optionOne.setText(currentQuestion.getOption1());
            optionTwo.setText(currentQuestion.getOption2());
            optionThree.setText(currentQuestion.getOption3());
            optionFour.setText(currentQuestion.getOption4());

            questionNumber.setImageResource(images[currentImage]);
            currentImage++;

            questionCounter++;
            answered = false;
            resultBtn.setEnabled(false);
        }
        else
        {
            resultBtn.setEnabled(true);
            confirmBtn.setEnabled(false);
            timer.stop();//Pause timer
            timeText = timer.getText().toString();
            //confirmBtn.setText(timeText);//iisipin pa
        }
    }

    private void checkAnswer()
    {
        answered = true;
        int id = radioGroupPlus.getCheckedRadioButtonId();
        int answerNumber = 0;

        switch (id)
        {
            case R.id.option1:
                answerNumber = 1;
                break;

            case R.id.option2:
                answerNumber = 2;
                break;

            case R.id.option3:
                answerNumber = 3;
                break;

            case R.id.option4:
                answerNumber = 4;
                break;
        }

        if (answerNumber == currentQuestion.getUserAnswer())
        {
            score++;
            scoreTextView.setText("Score: "+score);
        }
        showRightAnswer();
    }

    private void showRightAnswer()
    {
        linearLayoutOne.setBackgroundResource(R.drawable.background_wrong);
        linearLayoutTwo.setBackgroundResource(R.drawable.background_wrong);
        linearLayoutThree.setBackgroundResource(R.drawable.background_wrong);
        linearLayoutFour.setBackgroundResource(R.drawable.background_wrong);

        switch (currentQuestion.getUserAnswer())
        {
            case 1:
                linearLayoutOne.setBackgroundResource(R.drawable.background_correct);
                break;

            case 2:
                linearLayoutTwo.setBackgroundResource(R.drawable.background_correct);
                break;

            case 3:
                linearLayoutThree.setBackgroundResource(R.drawable.background_correct);
                break;

            case 4:
                linearLayoutFour.setBackgroundResource(R.drawable.background_correct);
                break;
        }

        if (questionCounter < questionsTotal)
        {
            confirmBtn.setText("Next");
        }
    }

    private void startTime()
    {
        int stoppedMillSeconds = 0;
        String chronometerTime = timer.getText().toString();
        String[] array = chronometerTime.split(":");

        if (array.length == 2)
        {
            stoppedMillSeconds = Integer.parseInt(array[0]) * 60 * 1000 + Integer.parseInt(array[1]) * 1000;
        }
        else if (array.length == 3)
        {
            stoppedMillSeconds = Integer.parseInt(array[0]) * 60 * 60 * 1000 + Integer.parseInt(array[1]) * 60 * 1000 + Integer.parseInt(array[2]) * 1000;
        }

        timer.setBase(SystemClock.elapsedRealtime() - stoppedMillSeconds);

        timer.start();
    }
}