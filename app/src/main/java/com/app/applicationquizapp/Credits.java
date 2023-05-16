package com.app.applicationquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Credits extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        pdfView = findViewById(R.id.pdfViewTutorialCredits);
        pdfView.fromAsset("credits-aimm.pdf").load();

    }
}