package com.app.applicationquizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultAct extends AppCompatActivity {

    private ImageView imageCongrats;
    private TextView scoreInteger, time;
    private Button finishButton;

    SharedPreferences sharedPreferencesResult;
    String quizToResult = "";
    String getTime = "";
    int getScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_act);

        quizToResult = getIntent().getStringExtra("QuizToResult");//GET THE NAME
        getTime = getIntent().getStringExtra("time");//GET TIME
        getScore = getIntent().getIntExtra("score",0);//GET SCORE

        imageCongrats = findViewById(R.id.imageQuizResult);
        scoreInteger = findViewById(R.id.scoreInt);
        time = findViewById(R.id.yourTimeId);
        finishButton = findViewById(R.id.finishId);


        if (getScore > 3)
        {
            imageCongrats.setImageResource(R.drawable.congratulation);
        }
        else
        {
            imageCongrats.setImageResource(R.drawable.sad);
        }
        time.setText(getTime);
        scoreInteger.setText(""+ getScore);

        sharedPreferencesResult = getSharedPreferences("QuizResult", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferencesResult.edit();
        editor.putString("quizTopic",quizToResult);

        switch (quizToResult)
        {
            case "permutation": //PERMUTATION
                editor.putString("resultTimeTextPerm", getTime);
                editor.putInt("resultScoreIntPerm", getScore);
                break;

            case "comForm"://COMBINATION FORMULA
                editor.putString("resultTimeTextComForm", getTime);
                editor.putInt("resultScoreIntComForm", getScore);
                break;

            case "permCom": //PERMUTATION OR COMBINATION
                editor.putString("resultTimeTextPermOrCom", getTime);
                editor.putInt("resultScoreIntPermPermOrCom", getScore);
                break;
        }

        editor.commit();


        /*
        editor.putString("quizTopic",quizToResult);
        editor.putString("resultTimeText", getTime);
        editor.putInt("resultScoreInt", getScore);
        editor.apply();
         */

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHome = new Intent(ResultAct.this, HomeActivity.class);
                Toast.makeText(ResultAct.this, "Quiz Finished", Toast.LENGTH_SHORT).show();
                startActivity(goHome);
            }
        });

    }
    public static void clearData(Context context)
    {
        SharedPreferences clear = context.getSharedPreferences("QuizResult", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = clear.edit();
        edit.clear();
        edit.commit();
    }
}