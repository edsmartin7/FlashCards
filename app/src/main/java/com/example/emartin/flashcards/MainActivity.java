package com.example.emartin.flashcards;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//card converter
//ml vision api converter
//upload and read document (different extensions) converter
//googledoc, .txt, .pdf,
//settings
//game screen/mode (keep track of points)
//voice recognition (given definition, speak one word answer) (duolingo)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void readFile(View view) {

            FileReader reader = new FileReader();
            reader.openFile(); //println?


    }

}
