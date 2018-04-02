package com.example.emartin.flashcards;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    public void readFile(View view) {

    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void addNotesCamera(View view) {
        Intent intent = new Intent(this, TakePictureActivity.class);
        startActivity(intent);
    }

    public void addNotesUpload(View view) {
        Intent intent = new Intent(this, FileUploadActivity.class);
        startActivity(intent);
    }

    public void userStats(View view) {
        Intent intent = new Intent(this, UserStatsActivity.class);
        startActivity(intent);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}
