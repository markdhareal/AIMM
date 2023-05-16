package com.app.applicationquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomeActivity extends AppCompatActivity {

    public CardView permutation,combinations,combinationFormula, permutationCombination;
    public String selectedQuiz = "";
    public String selectedTutorial = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().setStatusBarColor(ContextCompat.getColor(HomeActivity.this,R.color.status_bar_color));
        Toolbar toolbar = findViewById(R.id.toolBarID);
        setSupportActionBar(toolbar);

        permutation = (CardView) findViewById(R.id.permutationID);
        combinations = (CardView) findViewById((R.id.combinationsID));
        combinationFormula = (CardView) findViewById(R.id.combinationFormID);
        permutationCombination = (CardView) findViewById(R.id.permComID);

        permutation.setOnClickListener(this::onClick);
        combinations.setOnClickListener(this::onClick);
        combinationFormula.setOnClickListener(this::onClick);
        permutationCombination.setOnClickListener(this::onClick);
    }

    public void onClick(View v)
    {
        int id = v.getId();
        Intent intent = null;

        switch (id)
        {
            case R.id.permutationID:
            selectedQuiz = "permutation";
            selectedTutorial = "permutationTutorial";
            break;

            case R.id.combinationsID:
            selectedQuiz = "combinations";
            selectedTutorial = "combinationsTutorial";
            break;

            case R.id.combinationFormID:
            selectedQuiz = "comForm";
            selectedTutorial = "comFormTutorial";
            break;

            case R.id.permComID:
            selectedQuiz = "permCom";
            selectedTutorial = "permComTutorial";
            break;
        }
        intent = new Intent(HomeActivity.this, PlayTutorial.class);
        intent.putExtra("Game", selectedQuiz);
        intent.putExtra("Tutorial", selectedTutorial);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        Intent itemActivities = null;

        switch (itemId)
        {
            case R.id.wholeResult:
                itemActivities = new Intent(HomeActivity.this, WholeQuizResult.class);
                break;

            case R.id.creditsID:
                itemActivities = new Intent(HomeActivity.this, Credits.class);
                break;
        }

        startActivity(itemActivities);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return  true;
    }

}