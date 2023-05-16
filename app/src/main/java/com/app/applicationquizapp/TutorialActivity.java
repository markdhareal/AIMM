package com.app.applicationquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class TutorialActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);


        pdfView = (PDFView) findViewById(R.id.pdfViewTutorial);

        String getTutorial = getIntent().getStringExtra("TutorialName");

        switch (getTutorial)
        {
            case "permutationTutorial":
                pdfView.fromAsset("permutations.pdf").load();
            break;

            case "combinationsTutorial":
                pdfView.fromAsset("combinations.pdf").load();
            break;

            case "comFormTutorial":
                pdfView.fromAsset("combination-formula.pdf").load();
            break;

            default:
                pdfView.fromAsset("permutation-or-combination.pdf").load();
            break;
        }

    }
}