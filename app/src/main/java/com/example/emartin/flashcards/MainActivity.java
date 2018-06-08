package com.example.emartin.flashcards;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * The main home screen
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    //Start a new quiz game
    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    //Add notes to system by taking a new photo
    public void addNotesCamera(View view) {
        Intent intent = new Intent(this, TakePictureActivity.class);
        startActivity(intent);
    }

    //Add notes to system by checking for existing photos
    public void addNotesUpload(View view) {
        Intent intent = new Intent(this, FileUploadActivity.class);
        startActivity(intent);
    }

    //Get the user's current stats
    public void userStats(View view) {
        Intent intent = new Intent(this, UserStatsActivity.class);
        startActivity(intent);
    }

    //App settings
    public void openSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    //Testing adding notes by taking new photo
    public void readFile(View view) {
        Intent intent = new Intent(this, TextCaptureActivity.class);
        startActivity(intent);
    }

}
