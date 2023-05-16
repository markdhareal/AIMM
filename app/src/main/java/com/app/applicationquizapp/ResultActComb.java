package com.app.applicationquizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActComb extends AppCompatActivity {

    private TextView scoreTextIntComb, timeTextComb;
    private ImageView imageSadCongratsComb;
    private Button finishBtnComb;

    SharedPreferences sharedPreferencesResultComb;

    String getTimeComb = "";
    int getScoreComb = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_act_comb);

        getTimeComb = getIntent().getStringExtra("timeComb");
        getScoreComb = getIntent().getIntExtra("scoreComb", 0);

        scoreTextIntComb = findViewById(R.id.scoreIntComb);
        timeTextComb = findViewById(R.id.yourTimeIdComb);
        imageSadCongratsComb = findViewById(R.id.imageQuizResultComb);
        finishBtnComb = findViewById(R.id.finishIdComb);

        if (getScoreComb > 7)
        {
            imageSadCongratsComb.setImageResource(R.drawable.congratulation);
        }
        else
        {
            imageSadCongratsComb.setImageResource(R.drawable.sad);
        }

        timeTextComb.setText(getTimeComb);
        scoreTextIntComb.setText(""+getScoreComb);

        sharedPreferencesResultComb = getSharedPreferences("QuizResultComb", Context.MODE_PRIVATE);

        SharedPreferences.Editor editorComb = sharedPreferencesResultComb.edit();
        editorComb.putString("resultTimeTextComb", getTimeComb);
        editorComb.putInt("resultScoreIntComb", getScoreComb);
        editorComb.commit();

        finishBtnComb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHome = new Intent(ResultActComb.this, HomeActivity.class);
                Toast.makeText(ResultActComb.this, "Quiz Finished", Toast.LENGTH_SHORT).show();
                startActivity(goHome);
            }
        });

    }

    public static void clearComb(Context context)
    {
        SharedPreferences clearCombination = context.getSharedPreferences("QuizResultComb", Context.MODE_PRIVATE);
        SharedPreferences.Editor editComb = clearCombination.edit();
        editComb.clear();
        editComb.commit();
    }
}